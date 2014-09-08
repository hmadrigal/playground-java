use course;
db.grades.aggregate([
	 {$unwind : '$scores' }
	,{$match : { 'scores.type' : {$ne : 'quiz'}  } }
	,{$group : { _id : { student_id:'$student_id', class_id:'$class_id' }, avg_st_cl : {$avg : '$scores.score'}} }
	,{$group : { _id : '$_id.class_id', avg_cl : {$avg:'$avg_st_cl'}}}
	,{$sort : { avg_cl : 1 }}
]);
