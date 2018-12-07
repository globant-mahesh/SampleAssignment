Feature: Get book by ISBN

  Scenario: User calls web service to get a book by its ISBN
    Given a book exists with an isbn of 9781451648546
    When a user retrieves the book by isbn
    Then the status code is 200
    And response includes the following
      | totalItems | 1             |
      | kind       | books#volumes |
    And response includes the following in any order
      | items.volumeInfo.title     | Steve Jobs         |
      | items.volumeInfo.publisher | Simon and Schuster |
      | items.volumeInfo.pageCount | 630                |
      | items.volumeInfo.printType | BOOK               |
      | items.saleInfo.country     | IN                 |
      | items.selfLink             | https://www.googleapis.com/books/v1/volumes/8U2oAAAAQBAJ         |
      | items.volumeInfo.industryIdentifiers.type     | ISBN_13,ISBN_10                 |
      | items.volumeInfo.imageLinks.smallThumbnail            | http://books.google.com/books/content?id=8U2oAAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api         |
      


