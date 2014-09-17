use test;

// Images with 'sunrises' tag after deleting orphans
db.images.aggregate([
	 {$match : {tags : 'sunrises'} }
	,{$group : {_id:1, total:{$sum : 1}} }
])


db.albums.ensureIndex({images : 1 });
var found_image_ids = [];
db.images.find().forEach(function(image){
	var album = db.albums.findOne({ images : image._id });
	if (album) return;
	found_image_ids.push(image._id);
});
found_image_ids.forEach(function(image_id) {
	db.images.remove( { _id : image_id } );
});
print( " Removed Image Documents : " + found_image_ids.length);


// Images with 'sunrises' tag after deleting orphans
db.images.aggregate([
	 {$match : {tags : 'sunrises'} }
	,{$group : {_id:1, total:{$sum : 1}} }
])

// 44 787