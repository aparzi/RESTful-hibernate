# RESTful-hibernate
<b>SETUP</b><br>
Create a db with name db_example<br>
Into db, create a student table with the following fields
<ul>
  <li>Freshman</li>
  <li>Name</li>
  <li>Surname</li>
</ul>
<br>
<b>TESTING ENDPOINTS</b>
<p>Get all Student using GET http://localhost/api/students</p>
<code>
  [
    {
        "freshman": 123456,
        "name": "Angelo",
        "surname": "Parziale"
    }
]
</code>
