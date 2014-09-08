use course;
db.zips.aggregate([
	{$match : {$or : [{state:'CA'},{state:'NY'}]}},
	{$group : {_id:'$state'}}
]);
