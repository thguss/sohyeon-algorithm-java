select A.animal_id, A.name
from animal_ins A inner join animal_outs B on A.animal_id = B.animal_id
where A.datetime > B.datetime
order by A.datetime