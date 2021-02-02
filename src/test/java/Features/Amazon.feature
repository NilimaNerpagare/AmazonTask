Feature: Search Nikon Product on Amazon website

Scenario: Open Amazon page and search for Nikon D3X Product
Given User opens the browser
And navigate to Amazon webpage
And Search for Nikon Product
And Sort the results using filter
And selects the filter as highest price to Lowest
And selects the second product
And open the product details
Then verify if the product details display Nikon D3X