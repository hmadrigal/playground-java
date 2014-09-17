db.fubar.insert({a:0,b:0,c:0})
db.fubar.insert({a:0,b:0,c:1})
db.fubar.insert({a:0,b:1,c:0})
db.fubar.insert({a:0,b:1,c:1})
db.fubar.insert({a:1,b:0,c:0})
db.fubar.insert({a:1,b:0,c:1})
db.fubar.insert({a:1,b:1,c:0})
db.fubar.insert({a:1,b:1,c:1})

db.fubar.ensureIndex({a:1,b:1})
db.fubar.ensureIndex({a:1,c:1})
db.fubar.ensureIndex({c:1})
db.fubar.ensureIndex({a:1,b:1,c:-1})

// a_1_b_1
db.fubar.find({'a':{'$lt':10000}, 'b':{'$gt': 5000}}, {'a':1, 'c':1}).sort({'c':-1}).explain()
db.fubar.dropIndex({a:1,b:1})

// a_1_b_1_c_-1
db.fubar.find({'a':{'$lt':10000}, 'b':{'$gt': 5000}}, {'a':1, 'c':1}).sort({'c':-1}).explain()
db.fubar.dropIndex({a:1,b:1,c:-1})

// a_1_c_1
db.fubar.find({'a':{'$lt':10000}, 'b':{'$gt': 5000}}, {'a':1, 'c':1}).sort({'c':-1}).explain()
db.fubar.dropIndex({a:1,c:1})

// c_1
db.fubar.find({'a':{'$lt':10000}, 'b':{'$gt': 5000}}, {'a':1, 'c':1}).sort({'c':-1}).explain()
db.fubar.dropIndex({c:1})

// Basic Cursor
db.fubar.find({'a':{'$lt':10000}, 'b':{'$gt': 5000}}, {'a':1, 'c':1}).sort({'c':-1}).explain()