leetcode 1757. 可回收且低脂的产品
    select product_id
    FROM products
    WHERE low_fats     = 'Y' and recyclable  = 'Y'
--后续收录中难题和错题
leetcode 2356. 每位教师所教授的科目种类的数量
    select teacher_id ,count(distinct subject_id) as cnt
    from Teacher
    group by teacher_id

leetcode 1251. 平均售价
    select p.product_id,IFNULL(round(sum(p.price * u.units)/sum(u.units),2),0) as average_price
    from Prices as p left join UnitsSold u on p.product_id = u.product_id
    where (u.purchase_date BETWEEN p.start_date and p.end_date) or u.purchase_date is NULL
    GROUP BY p.product_id
    //前者速度慢 因为加了or 后者更快因为连接条件这里加入了查询，但是left又保留了Prices表里有的而UnitsSold里没有的

    SELECT p.product_id, IFNULL(ROUND(SUM(p.price * u.units)/SUM(u.units), 2), 0) as 'average_price'
    FROM UnitsSold as u
    right JOIN
        Prices as p
    ON
        u.product_id = p.product_id AND
        p.start_date <= u.purchase_date AND
        u.purchase_date <= p.end_date
    group by p.product_id
leetcode 1174. 即时食物配送 II

select round(sum(order_date = customer_pref_delivery_date)*100/count(DISTINCT customer_id,order_date ) ,2)as immediate_percentage
from delivery
where (customer_id,order_date) in (
select customer_id, min(order_date)
    from delivery
    group by customer_id

		)
leetcode 1164. 指定日期的产品价格★★
#好题
#distinct id 作为id表  结果作为辅助temp 连接 得到结果
SELECT
	p.product_id,
IF( temp.product_id IS NULL, 10, temp.new_price ) AS price
FROM
	( SELECT DISTINCT product_id FROM products ) AS p LEFT JOIN ( #★★
SELECT product_id,new_price
FROM products
WHERE ( product_id, change_date ) IN ( SELECT product_id, max( change_date ) AS newdate FROM Products WHERE change_date <= '2019-08-16' GROUP BY product_id )
	) AS temp ON p.product_id = temp.product_id

1204. 最后一个能进入巴士的人★★★
#巧妙自连接 通过turn获得在自己之前进入巴士的人，然后分组统计过滤
SELECT a.person_name
FROM Queue a, Queue b#★
where a.turn >= b.turn #★
GROUP BY a.person_id
HAVING sum(b.weight) <= 1000
ORDER BY a.turn desc
LIMIT 1

626. 换座位
#奇偶问题三次连接
select s1.id,case when s1.id%2=1 then if(s2.student is null,s1.student,s2.student) else s3.student end as student
from Seat as s1 left join Seat as s2 on s1.id +1  = s2.id left join Seat as s3 on s1.id -1 = s3.id
order by s1.id

1321. 餐馆营业额变化增长
#子查询 t1 t2 连接 套用窗口问题
select t1.visited_on,sum(t2.amount) as amount       , round(avg(t2.amount),2) as average_amount
from (  SELECT visited_on, SUM(amount) AS amount
        FROM Customer
        GROUP BY visited_on
) as t1 right join (
        SELECT visited_on, SUM(amount) AS amount
        FROM Customer
        GROUP BY visited_on
) as t2 on datediff(t1.visited_on,t2.visited_on) <= 6 and datediff(t1.visited_on,t2.visited_on) >= 0
GROUP BY t1.visited_on
HAVING count(*)=7

★185. 部门工资前三高的所有员工
表1 的列可带入where的子查询进行条件
SELECT d.Name AS 'Department', e1.Name AS 'Employee', e1.Salary
FROM Employee e1 JOIN Department d ON e1.DepartmentId = d.Id
WHERE  (SELECT COUNT(DISTINCT e2.Salary) #去重 保证第一第二第三
        FROM Employee e2
        WHERE e2.Salary > e1.Salary AND e1.DepartmentId = e2.DepartmentId) < 3


// datediff 日期差函数 DATE_ADD 日期变更函数 year(created_at)='2020' and month(created_at)='02' 年月日函数
// DATE_FORMAT(trans_date, '%Y-%m') DATE_FORMAT(date,format)用于以不同的格式显示日期/时间数据
// BETWEEN DATE_ADD('2019-07-27',INTERVAL -29 day) and '2019-07-27'
// IF(条件,1,0) ★★★★★
// round(value,2) 保留2位
// group by product_id having MAX(sale_date) <= '2019-03-31'
   and MIN(sale_date) >= '2019-01-01'
   只有group by之后才能用 having ，having可以使用聚合函数
// CASE [col_name] WHEN [value1] THEN [result1]…ELSE [default] END
   CASE WHEN [expr] THEN [result1]…ELSE [default] END
// where (列1,列2) in (select ....)
// 字符串函数 CONCAT(UPPER(SUBSTRING(name, 1, 1)), LOWER(SUBSTRING(name, 2))) AS name
// union 去重合并 union all 不去重合并
// over 函数的替代，因为mysql5.7不能使用over函数,使用子查询替代 #1321
    SELECT t1.id, t1.value, SUM(t2.value) AS cumulative_sum
    FROM my_table t1
    JOIN my_table t2 ON t2.id <= t1.id
    GROUP BY t1.id
    ORDER BY t1.id;
