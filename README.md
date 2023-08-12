# CSV-Validation - Java 8

This program reads a CSV file, validates the input data, and outputs the data to standard output. It performs validation on fields like **id**, **name**, **birthday**, **gender**, and **phone number** based on specific rules. The validated data is output along with error messages for invalid data. The header of the CSV file is excluded from validation.

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
| id  | Mandatory<br>Numerical  | Error Required<br>Error Format | Mandtory Item.<br>Numerical values only.
| name  | Mandatory, Length limitation  | Error required<br>Error limit over | Mandatory item.<br>100 characters only.
| birthday  | Mandatory<br>Format  | Error required<br>Error format | Mandatory Item, yyyy/mm/dd or yyyy-mm-dd format only 
| gender  | Format  | Error format | **Male** or **Female** (uppercase, lowercase, or empty data is allowed.)
| phone-number  | Mandatory<br>Format  |Error required<br>Error format| Mandatory item. Format should be 000-0000-0000 or 00-0000-0000 or 000-000-0000 or 0000-00-0000 half-width number format or 00000000000 half-width number format around 10-11 characters.

