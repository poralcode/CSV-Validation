# CSV-Validation

An example of how to reads a CSV file, validate the input data, and output the data to standard output. It performs validation on fields like **id**, **name**, **birthday**, **gender**, and **phone number** based on specific rules. The validated data is output along with error messages for invalid data. The header of the CSV file is excluded from validation.

There are only two classes in this project.<br>
[Main.java ](https://github.com/poralcode/CSV-Validation/blob/origin/src/main/java/Main.java "Main.java ")- The main class that contains the logic for reading the CSV file.<br>
[Validation.java](https://github.com/poralcode/CSV-Validation/blob/origin/src/main/java/Validation.java "Validation.java") - The class that provides validation logic for the fields in a CSV file.

------------


**SAMPLE FILE INPUT:**  writers.csv
> id,name,birthday,gender,phone-number<br>
1,Liam,02/1994/29,male,09011112222<br>
2,Austin,1994/10/10,female,08033334444<br>
3,,1989/01/23,female,0355556666<br>

------------


**CONSOLE OUTPUT:**
> id,name,birthday,gender,phone-number<br>
1,Liam,**Error format**,male,09011112222<br>
2,Austin,1994/10/10,female,08033334444<br>
3,**Error required**,1989/01/23,female,0355556666

------------


**VALIDATION DETAILS:**

| FIELD           | VALIDATION | ERROR MESSAGE | CONDITIONS     |
| ------------- | -------------- | ------------------- | ------------------ |
| id  | Mandatory, Numerical  | Error Required, Error Format | Mandtory Item. Numerical values only.
| name  | Mandatory, Length limitation  | Error required, Error limit over | Mandatory item. 100 characters only.
| birthday  | Mandatory, Format  | Error required, Error format | Mandatory Item. yyyy/mm/dd or yyyy-mm-dd format only 
| gender  | Format  | Error format | **Male** or **Female** (uppercase, lowercase, or empty data is allowed.)
| phone-number  | Mandatory, Format  |Error required, Error format| Mandatory item. Format should be 000-0000-0000 or 00-0000-0000 or 000-000-0000 or 0000-00-0000 half-width number format or 00000000000 half-width number format around 10-11 characters.

