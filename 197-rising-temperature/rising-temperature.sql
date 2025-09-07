select w.id
from Weather w
join Weather v
where datediff(w.recordDate , v.recordDate) = 1 and w.temperature>v.temperature;