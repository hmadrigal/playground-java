use enron;
var sender = 'andrew.fastow@enron.com';
var recipient = 'jeff.skilling@enron.com';
//var recipient = 'john.lavorato@enron.com';

db.messages.aggregate([
	 {$match : { 'headers.From' : sender } }
	,{$unwind : '$headers.To' }
	,{$match : { 'headers.To' : recipient } }
	,{$group : { _id : 1 , email_count : {$sum : 1} } }
]);
