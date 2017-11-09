# RESTful-hibernate
<b>SETUP</b>
<li>Create a db with name db_example</li>
<li>Into db, create a student table with the following fields</li>
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
