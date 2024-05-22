#Втора лабораториска вежба по софтверско инженерство

## Јован Давалиев 226035

###Одговори

#### Control Flow Graph 

 ![Project graph](https://drive.google.com/file/d/1deAU837j8UIr82qma_fnWt6Zhoj_3XlW/view)

### Цикломатската комплексност

  Цикломатската комплексност на овој код е 10, и  ја добив преку формулата E-N+2, каде што E е бројот на ребра и N е бројот на темиња. Во случајoв E=36 N=28 и оттука следува дека Цикломатската комплексност е 36-28+2=10.

### Тест случаи според Every Branch критериумот:

![Test Case](https://drive.google.com/file/d/1mwBNV8FhKZVXVF-Z_6SATXy1fs1wmIkX/view)

Тест примери:
     1. Item("","0213",360,4.5f),payment:250
     2. null,payment:200
     3. Item("Nivea Kozmetika","0813",350,0),payment 530
     4. Item("Cedevita","-1",78,5.3f),payment:300
     5. Item("Leb",null,35,3.4f),payment:130

### Тест случаи според тест критериумот за  Multiple Condition 

 if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0')
 
Можни услови:
	Т && T && T => item.getPrice()>300, item.getDiscount() > 0, item.getBarcode().charAt(0) == '0'
	F && X && X => item.getPrice()<=300,item.getDiscount() = anything, item.getBarcode().charAt(0) = anything
        T && F && X => item.getPrice()>300,item.getDiscount()<=0, item.getBarcode().charAt(0) = anything
        T && T && F => item.getPrice()>300,item.getDiscount()>0, item.getBarcode().charAt(0) != '0'