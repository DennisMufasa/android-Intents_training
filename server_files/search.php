<?php

$host = 'localhost';
$username = 'root';
$password = '';
$database = 'school';

$conn = mysqli_connect($host, $username, $password, $database);

// if($conn){
//     echo "Connection successful!";
// }else{
//     echo "Something went wrong".mysqli_connect_error();
// }

extract($_REQUEST);

$sql = "SELECT `admNo`, `name`, `course`, `doA` FROM `students` WHERE `name`='$search'";

$results = mysqli_query($conn, $sql);

if(mysqli_num_rows($results) > 0){
    $row = mysqli_fetch_assoc($results);
    echo "username  -  ".$row['name']."#email  -  ".$row['course']."#date of admission - ".$row['doA'];
}else{
    echo "That user doesnt exist!";
}

mysqli_close($conn);


?>
