/*q1*/
Select d.Name,  count(c.id) 
FROM department d 
INNER JOIN course c 
ON d.id = c.deptId
group by c.deptId
ORDER BY  COUNT(c.id) ASC, 
          d.NAME ASC;

/*q2*/
SELECT c.name, count(*)
FROM studentCourse s
INNER JOIN course c
ON s.courseId = c.id
group by s.courseId
order by 2 desc, 1;

/*q3*/
select c.name
from course c left join facultyCourse fc
on c.id = fc.courseId
where fc.facultyId is NULL;

/*q4*/
select c.name, count(*)
from course c 
left join facultyCourse fc
on c.id = fc.courseId
left join studentCourse s
on c.id = s.courseId
where fc.facultyId is NULL
group by c.name
order by 2 desc, 1;

/*q5*/
select count(distinct sc.studentId) as "Students", Year(sc.startDate) as "Year"
from studentCourse sc
group by YEAR(sc.startDate)
order by 2 asc, 1 desc;

/*q6*/
select sc.startDate, count(distinct sc.studentId)
from studentCourse sc
where month(sc.startDate) = 8
group by sc.startDate
order by 1 asc, 2 asc;

/*q7*/
select s.firstname, s.lastname, count(*)
from student s
inner join studentCourse sc
on s.id = sc.studentId
inner join course c
on sc.courseId = c.Id
where s.majorId = c.deptId
group by s.firstname, s.lastname
order by 3 desc, 1 asc, 2 asc;

/*q8*/
select s.firstname, s.lastname, 
cast(avg(sc.progress) as decimal(3,1))
from student s
inner join studentCourse sc
on s.id = sc.studentId
group by s.firstname, s.lastname
having avg(sc.progress)  <= 50
order by 3 desc, 1 asc, 2 asc;

/*q9*/
select c.name, cast(avg(sc.progress) as decimal(3,1))
from course c 
inner join studentCourse sc
on c.id = sc.courseId
group by c.name
order by 2 desc, 1 asc;

/*10*/
select c.name, cast(avg(sc.progress) as decimal(3,1))
from course c 
inner join studentCourse sc
on c.id = sc.courseId
group by c.name
order by 2 desc
limit 1;

/*11*/
select f.firstname, f.lastname, 
cast(avg(sc.progress) as decimal(3,1))
from faculty f inner join facultyCourse fc
on f.id = fc.facultyId
inner join course c
on fc.courseId = c.id
inner join studentCourse sc
on c.id = sc.courseId
group by f.firstname, f.lastname
order by 3 desc, 1 asc, 2 asc;

/*12*/
select f.firstname, f.lastname, 
cast(avg(sc.progress) as decimal(3,1))
from faculty f inner join facultyCourse fc
on f.id = fc.facultyId
inner join course c
on fc.courseId = c.id
inner join studentCourse sc
on c.id = sc.courseId
group by f.firstname, f.lastname
having avg(sc.progress) >= 62.82
order by 3 desc, 1 asc, 2 asc;

/*13*/
select s.firstname, s.lastname, 
(SELECT CASE  
    WHEN min(sc.progress) < 40 THEN 'F'
    WHEN min(sc.progress) >= 40 
    and min(sc.progress) < 50 THEN 'D'
    WHEN min(sc.progress) >= 50 
    and min(sc.progress) < 60 THEN 'C'
    WHEN min(sc.progress) >= 60 
    and min(sc.progress) < 70 THEN 'B'
    WHEN min(sc.progress) >= 70 THEN 'A'
    ELSE 'ERRORS' END),
(SELECT CASE  
    WHEN max(sc.progress) < 40 THEN 'F'
    WHEN max(sc.progress) >= 40 
    and max(sc.progress) < 50 THEN 'D'
    WHEN max(sc.progress) >= 50 
    and max(sc.progress) < 60 THEN 'C'
    WHEN max(sc.progress) >= 60 
    and max(sc.progress) < 70 THEN 'B'
    WHEN max(sc.progress) >= 70 THEN 'A'
    ELSE 'ERRORS' END)
from student s 
join studentCourse sc 
on s.id = sc.studentId
group by s.id
order by 3 desc, 4 desc, 
1 asc, 2 asc;
