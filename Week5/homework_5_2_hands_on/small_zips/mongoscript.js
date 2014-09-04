use course;
db.zips.aggregate([
	 {$group : { _id : {state:'$state',city:'$city'}, sum_pop:{$sum:'$pop'} } }
	,{$match : {$and : [ {sum_pop: {$gt : 25000} }  ,{$or : [{'_id.state':'CA'} , {'_id.state':'NY'}]} ] } }
	,{$group : { _id : 1, avg_pop: {$avg: '$sum_pop'} } }
]);
