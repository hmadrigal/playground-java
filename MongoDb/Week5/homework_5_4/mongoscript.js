use course;
db.zips.aggregate([
	 {$project : {
	 	 first_char: {$substr : ['$city',0,1] }
	 	,pop : '$pop'
	}}
	,{$match : { $and : [{first_char:{$gte:'0'}},{first_char:{$lte:'9'}}] } }
	,{$group : { _id : 1, sum_pop:{$sum:'$pop'}}}
]);
