Feature: Movie Information Validation

@Sanity
Scenario: Verify Puspa movie in IMBD and WIKI
Given If user is on IMBD page
When  Search for "Pushpa:The Rise" movie in IMBD 
And   Get release date & country in IMBD
And   Load WIKI page 
And   Search for "Pushpa:The Rise" movie in WIKI
And   Get release date & country IN WIKI
Then  Verify the movie Details in Both IMBD and WIKI
