use school;
db.students.find().forEach(function(student) {
	var lowestHomeworkScore = student
		.scores
		.filter(function(score){ return score.type == 'homework'})
		.reduce(function(previousValue,currentValue,index,array){
			if (!previousValue) return currentValue;
			return (previousValue.score < currentValue.score) ? previousValue : currentValue;
		});
	
	print( '[' + student._id + ']' + student.name + ' lowest score ' + lowestHomeworkScore.score );
	db.students.update( { _id : student._id } , { $pull : { 'scores' : lowestHomeworkScore  } } );	
});
