select A.animal_id, A.animal_type, A.name
from animal_ins A inner join animal_outs B on A.animal_id = B.animal_id
where (A.sex_upon_intake like 'Intact%')
    and (B.sex_upon_outcome like 'Spayed%' or B.sex_upon_outcome like 'Neutered%')
order by A.animal_id