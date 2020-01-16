# lego-store

Springboot & Mongodb

* DbSeeder is used to prepopulate the database
* Data model

![image](https://user-images.githubusercontent.com/6619191/72564798-deb49e80-38b0-11ea-9bd7-2f0261e6b42d.png)

| SQL | NoSQL  | 
| :---:   | :-: | 
| Table | Collection | 
| Rows | Document | 
| Columns | Fields | 
| Indexes | Indexes | 
| Relationships | Sub-documents(references) | 



| INSERT | SAVE  | 
| :---:   | :-: | 
| If the object has no Id (Id is null), a new Id will get generated | If the object has no Id (Id is null), a new Id will get generated | 
| If the object has an Id value | If the object has Id value | 
| If Id value not already present in the collection, will use it to insert | If Id value not already present, will use it | 
| Else, MongoDB will throw a Duplicate Key exception | If Id value present, will update the document | 
