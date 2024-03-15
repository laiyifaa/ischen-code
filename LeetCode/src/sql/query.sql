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

// datediff 日期差函数 DATE_ADD 日期变更函数
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

