<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Perpustakaan</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
  </head>
<body>

    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="index.jsp">Perpustakaan</a>
          <div class="nav-collapse">
            <ul class="nav">
              <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      Book
                      <b class="caret"></b>
                  </a>
                  <ul class="dropdown-menu">
                      <li>
                          <a href="index.jsp">View All Book</a>
                          <a href="insertBook.jsp">Insert New Book</a>
                      </li>
                  </ul>
              </li>
              <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      Author
                      <b class="caret"></b>
                  </a>
                  <ul class="dropdown-menu">
                      <li>
                          <a href="viewAuthor.jsp">View All Author</a>
                          <a href="insertNewAuthor.jsp">Insert New Author</a>
                      </li>
                  </ul>
              </li>
              <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      Publisher
                      <b class="caret"></b>
                  </a>
                  <ul class="dropdown-menu">
                      <li>
                          <a href="viewPublisher.jsp">View All Publisher</a>
                          <a href="insertNewPublisher.jsp">Insert New Publisher</a>
                      </li>
                  </ul>
              </li>
              <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      Category
                      <b class="caret"></b>
                  </a>
                  <ul class="dropdown-menu">
                      <li>
                          <a href="viewCategory.jsp">View All Category</a>
                          <a href="insertNewCategory.jsp">Insert New Category</a>
                      </li>
                  </ul>
              </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>