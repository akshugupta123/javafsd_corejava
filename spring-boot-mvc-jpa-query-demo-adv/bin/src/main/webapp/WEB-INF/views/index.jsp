<a href="list-products">List All Products</a>
<a href="list-products-price-is-1000">List All Products with Price exactly 1000</a>

<br><br>
<h2>Search product by name keyword and min price and max price (implemented using Criteria/Specfication API)</h2>
<form action="/list-products-by-name-like-and-price-between-min-max" method=GET>
NAME like: <input name=name>
<br>PRICE (greater than): <input name=minP> &nbsp;&nbsp;
PRICE (less than): <input name=maxP>
<br><br>
<input type=submit value="SEARCH">
</form>

<br><br>

<br><br>
<h2>Search product by name keyword using SQL native query</h2>
<form action="/list-products-by-name-like-using-sql" method=GET>
NAME like: <input name=name>
<input type=submit value="SEARCH">
</form>

<br><br>

<br><br>
<h2>Search product by name keyword using JPQL @Query</h2>
<form action="/list-products-by-name-like" method=GET>
NAME like: <input name=name>
<input type=submit value="SEARCH">
</form>

<br><br>
<hr/>

<br><br>
<h2>Search product by name and price greater than</h2>
<form action="/list-products-by-price-gt" method=GET>
PRICE (greater than): <input name=price>
<input type=submit value="SEARCH">
</form>

<br><br>


<h2>Search product by name</h2>
<form action="list-products-by-name" method=GET>
NAME: <input name=name>
<input type=submit value="SEARCH">
</form>

<br><br>
<hr/>
<br><br>
<a href="add-product">Add a new Product</a>

<br><br>
EDIT this Product<br>
<form action="edit-product" method=GET>
ID: <input name=id>
<input type=submit value="EDIT">
</form>

<br><br>
DELETE this Product<br>
<form action="delete-product" method=GET>
ID: <input name=id>
<input type=submit value="EDIT">
</form>