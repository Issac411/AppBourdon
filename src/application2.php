<?php
  mysql_connect("localhost","root","Dragon159789");
  mysql_select_db("renouvellement");
  $sql=mysql_query("SELECT * FROM administrateur");
  while($row=mysql_fetch_assoc($sql))
  $output[]=$row;
  print(json_encode($output));
  mysql_close();
?>