# Meeting Planner - Unit Testing

## Төслийн тухай

Уулзалт товлох систем. Ажилтнуудын уулзалт болон өрөөний захиалгыг удирдана.

## Тестийн тайлан

Нийт тест: 20

| Класс | Тестийн тоо |
|-------|------------|
| CalendarTest | 8 |
| MeetingTest | 2 |
| PersonTest | 3 |
| RoomTest | 3 |
| OrganizationTest | 4 |

## Хэрхэн ажиллуулах

### Тест ажиллуулах
```bash
mvn test
```

### Програм ажиллуулах
```bash
mvn compile
mvn exec:java -Dexec.mainClass="edu.sc.csce747.MeetingPlanner.PlannerInterface"
```

### JAR файл үүсгэх
```bash
mvn package
java -jar target/meeting-planner-1.0-SNAPSHOT.jar
```

## Файлын бүтэц

```
src/main/java/          - Үндсэн код
src/test/java/          - Тест код
pom.xml                 - Maven тохиргоо
```

## Классуудын тайлбар

**Calendar.java** - Календар удирдлага, огноо/цаг шалгах, давхцал илрүүлэх

**Meeting.java** - Уулзалтын мэдээлэл хадгалах

**Person.java** - Ажилтны мэдээлэл болон календар

**Room.java** - Өрөөний мэдээлэл болон календар

**Organization.java** - Ажилтан болон өрөөний жагсаалт удирдах

**PlannerInterface.java** - Хэрэглэгчийн интерфэйс

## Тестийн төрөл

### Зөв тохиолдол
- Хэвийн уулзалт нэмэх
- Амралтын өдөр товлох
- Сул эсэх шалгах

### Буруу тохиолдол
- Буруу огноо (2 сарын 35, 13-р сар)
- Буруу цаг (сөрөг утга, 24 цаг)
- Эхлэх цаг дуусах цагаас хойш
- Цагийн давхцал
- Байхгүй ажилтан/өрөө

## Ашигласан технологи

- Java 21
- Apache Maven 3.9.9
- JUnit 4.13.2

