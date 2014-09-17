use enron;
db.messages.aggregate([
	 {$unwind : '$headers.To'}
	,{$group : {
		_id: '$_id', 
		To : {$addToSet : '$headers.To'},
		From: {$first : '$headers.From'}}}
	,{$unwind : '$To'}
	,{$group: {
		_id : { from : '$From', to : '$To' }, 
		email_count:{$sum : 1}}}
	,{$sort : {email_count:-1}}
	,{$limit : 5} ]);