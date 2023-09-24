// script.js
function fetchBooks() {
    var authorName = document.getElementById("authorSelect").value;

    //  AJAX request to fetch books by author
    fetch('/books/' + encodeURIComponent(authorName)) // Encode writerName in case it contains special characters
        .then(response => response.json())
        .then(data => {

            var tableBody = document.getElementById("bookTableBody");

            tableBody.innerHTML = "";

            data.forEach(book => {
                var row = tableBody.insertRow();


                var idCell = row.insertCell(0);
                var bookNameCell = row.insertCell(1);
                var authorNameCell = row.insertCell(2);
                var priceCell = row.insertCell(3);
                var publicationYearCell = row.insertCell(4);
                var updateCell = row.insertCell(5);


                var updateLink = document.createElement("a");
                updateLink.setAttribute("href", "/updateBook");
                updateLink.setAttribute("class", "btn btn-primary btn-sm mb-3");
                updateLink.innerHTML = '<i class="fa fa-update"></i> Update';


                idCell.innerText = book.id;
                bookNameCell.innerText = book.bookName;
                authorNameCell.innerText = book.authorName;
                priceCell.innerText = book.price;
                publicationYearCell.innerText = book.publicationYear;
                updateCell.appendChild(updateLink);
            });
        })
        .catch(error => {
            console.error('Error fetching books:', error);
        });
}

function searchBooks(){

    var searchWith = document.getElementById("searchWith").value;


    fetch('search/books/' + encodeURIComponent(searchWith))
        .then(response => response.json())
        .then(data => {

            var tableBody = document.getElementById("bookTableBody");

            tableBody.innerHTML = "";

            data.forEach(book => {
                var row = tableBody.insertRow();


                var idCell = row.insertCell(0);
                var bookNameCell = row.insertCell(1);
                var authorNameCell = row.insertCell(2);
                var priceCell = row.insertCell(3);
                var publicationYearCell = row.insertCell(4);
                var updateCell = row.insertCell(5);


                var updateLink = document.createElement("a");
                updateLink.setAttribute("href", "/updateBook");
                updateLink.setAttribute("class", "btn btn-primary btn-sm mb-3");
                updateLink.innerHTML = '<i class="fa fa-update"></i> Update';


                idCell.innerText = book.id;
                bookNameCell.innerText = book.bookName;
                authorNameCell.innerText = book.authorName;
                priceCell.innerText = book.price;
                publicationYearCell.innerText = book.publicationYear;
                updateCell.appendChild(updateLink);
            });
        })
        .catch(error => {
            console.error('Error fetching books:', error);
        });

}
