<!DOCTYPE html>
<html lang="en">

<head>
    <title>Student Info</title>
    <style>
        .center-form {
            display: flex;
            justify-content: center;   
            align-items: flex-start;   
            height: 100vh;
            padding-top: 30px; 
        }
        button {
            margin-left: 150px;
        }

        legend {
            background-color: black;
            color: white;
            padding: 5px 10px;
            border-radius: 0px 20px;
        }

        fieldset {
            background-color: aqua;
            height: auto;
            width: 80%;
            padding-right: 0px;
        }
        table{
           padding-left: 6px; 
        }
        .center-form{
            background-color: rgba(14, 136, 89, 0.119);
        }
    </style>
</head>

<body>
    <div class="center-form">
    <form action="">
        <fieldset>
            <legend>
                Student Registration
            </legend>
            <table width="100%">
                <tr>
                    <td><label for="">Student Id</label></td>
                    <td><input type="number" name="id" placeholder="Enter the id"></td>
                </tr>
                <tr>
                    <td><label for="">Student Name</label></td>
                    <td><input type="text" name="name" placeholder="Enter the name"></td>
                </tr>
                    <td><label for="">Student Age</label></td>
                    <td><input type="number" name="age" placeholder="Enter the age"></td>
                </tr>
                <tr>
                    <td><label for="">Gender</label></td>
                    <td><input type="radio" name="radio">male
                        <input type="radio" name="radio">female
                        <input type="radio" name="radio">others
                    </td>
                </tr>
                <tr>
                    <tr>
                        <td><label for="">Courses</label></td>
                        <td><select name="" id="">
                                <option value="">-----select-----</option>
                                <option value="">Java Full Stack Developer</option>
                                <option value="">Python Full Stack Developer</option>
                                <option value="">Mern Stack Developer</option>
                                <option value="">Mean Stack Developer</option>
                            </select></td>
                    </tr>
            
                    <tr>
                        <td colspan="1" align="center"> <button>display</button> </td>
                    </tr>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>

</html>