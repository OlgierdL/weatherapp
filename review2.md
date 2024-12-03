### Reviewed repo
https://github.com/OlgierdL/weatherapp
### Review
The code looks good and follows OOP and SOLID principles. Each class and method has a clear purpose (SRP), and the code can be extended without breaking existing functionality (OCP). 
While it doesn’t use much polymorphism or interfaces, it still works well and supports flexibility (LSP).
Adding more interfaces or abstract classes could improve reusability and make the code easier to extend in the future.
One improvement would be to use a library like Jackson for JSON deserialization (see screenshot below). 
This would make the code cleaner, reduce bugs, and save time compared to manual handling. 
https://github.com/OlgierdL/weatherapp/blob/b45ff641d78cc8ea7a462c0db635ea837f298f38/src/main/java/WeatherAPI.java#L43-L55
![image](https://github.com/user-attachments/assets/0593cb1f-e5e2-48e5-8515-9cd895386198)
