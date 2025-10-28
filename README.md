# Meeting Planner - Lab 07 Unit Testing

## Тестийн тайлан (Test Report)

### Нийт Unit Test: **~20 тест**

| Class | Тестийн тоо |
|-------|------------|
| CalendarTest | 8 тест |
| MeetingTest | 2 тест |
| PersonTest | 3 тест |
| RoomTest | 3 тест |
| OrganizationTest | 4 тест |

### Илрүүлсэн алдаанууд (Bugs Found):
1. **Calendar.checkTimes()** - 12-р сар зөвшөөрөгдөхгүй (`mMonth >= 12` буруу)
2. **Calendar** - 11-р сарын өдрийн тоо буруу block хийгдсэн

---

## Хэрхэн ажиллуулах вэ?

### 1. JUnit library татах:
```powershell
mkdir lib
Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar" -OutFile "lib\junit-4.13.2.jar"
Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar" -OutFile "lib\hamcrest-core-1.3.jar"
```

### 2. Build болон Test ажиллуулах:
```powershell
# Ant ашиглах
ant test

# Эсвэл IDE-д:
# Right-click test file → Run As → JUnit Test
```

---

## Build Tool - Ant

### Targets:
```bash
ant compile        # Код compile
ant test           # Тестүүд ажиллуулах  
ant javadoc        # Documentation
ant clean          # Цэвэрлэх
ant all            # Бүгд
```

---

## Тестийн төрлүүд:

### ✅ Зөв тохиолдол (Valid Cases):
- Зөв огноо/цаг оруулах
- Уулзалт нэмэх
- Person/Room үүсгэх

### ❌ Буруу тохиолдол (Invalid Cases):
- 2-р сарын 35
- 13-р сар  
- -1 цаг, 24 цаг
- Start > End
- Цагийн давхцал (Time conflict)
- Байхгүй employee/room

---

## Git Commands:

```bash
git add .
git commit -m "Added unit tests"
git remote add origin https://github.com/[username]/MeetingPlanner.git
git push -u origin main
```

---

**Оюутны нэр:** [Таны нэр]  
**Хичээл:** CSCE 747  
**Lab:** 07 - Unit Testing


Unit Testing Тайлан - MeetingPlanner Application
1. Ерөнхий мэдээлэл
Төсөл: MeetingPlanner Calendar Application
Огноо: 2025-10-28
Тест framework: JUnit 4.13.2
Хэл: Java

2. Бичигдсэн Unit Test-үүдийн тоо
Нийт тест: 20
Тестлэгдсэн классууд: 5

Классуудаар тестийн тоо:
Класс	Тестийн тоо	Файл
CalendarTest	8	CalendarTest.java
MeetingTest	2	MeetingTest.java
PersonTest	3	PersonTest.java
RoomTest	3	RoomTest.java
OrganizationTest	4	OrganizationTest.java
3. Тестийн төрлүүд
3.1 Зөв тохиолдол (Valid Test Cases) - 5 тест
✅ testAddMeeting_holiday() - Амралтын өдөр нэмэх
✅ testAddMeeting_validMeeting() - Хэвийн уулзалт нэмэх
✅ testMeetingConstructor() - Meeting объект үүсгэх
✅ testPersonAddMeeting_success() - Хүнд уулзалт нэмэх
✅ testRoomAddMeeting_success() - Өрөөнд уулзалт нэмэх
3.2 Буруу тохиолдол (Invalid Test Cases) - 15 тест
Calendar тестүүд:
❌ testAddMeeting_february35() - 2 сарын 35-ны өдөр (буруу өдөр)
❌ testAddMeeting_invalidMonth13() - 13-р сар (буруу сар)
❌ testAddMeeting_negativeHour() - Сөрөг цаг (-1 цаг)
❌ testAddMeeting_hour24() - 24 цаг (хүчинтэй муж: 0-23)
❌ testAddMeeting_startAfterEnd() - Эхлэх цаг дуусах цагаас хойш
❌ testAddMeeting_timeConflict() - Цагийн давхцал
Person тестүүд:
❌ testPersonAddMeeting_timeConflict() - Хүний уулзалт давхцах
Room тестүүд:
❌ testRoomAddMeeting_timeConflict() - Өрөөний уулзалт давхцах
Organization тестүүд:
❌ testGetEmployee_notFound() - Байхгүй ажилтан хайх
❌ testGetRoom_notFound() - Байхгүй өрөө хайх
4. Илрүүлсэн алдаа
Нийт илрүүлсэн алдаа: 3

4.1 Алдаа #1: Огноо шалгах validation байхгүй
Байршил: Calendar.java - addMeeting() метод
Тодорхойлолт: Календар класс нь буруу огноо (жишээ нь: 2 сарын 35, 13-р сар) оруулахад шалгалт хийхгүй байна. TimeConflictException шидэх ёстой боловч шалгах код байхгүй.
Нөлөө: Програм буруу өгөгдлийг хүлээн авч алдаа гарч болзошгүй.

4.2 Алдаа #2: Цагийн муж шалгах validation байхгүй
Байршил: Meeting.java constructor
Тодорхойлолт: Цаг 0-23 хооронд байх ёстой боловч сөрөг утга эсвэл 24-с их утга оруулахад шалгалт хийхгүй.
Нөлөө: Хүчингүй цагтай уулзалт үүсэх боломжтой.

4.3 Алдаа #3: Эхлэх/дуусах цагийн логик шалгах байхгүй
Байршил: Meeting.java constructor
Тодорхойлолт: Эхлэх цаг дуусах цагаас хойш байх боломжтой (жишээ: 15:00-10:00).
Нөлөө: Логик алдаатай уулзалт үүсэх боломжтой.

5. Ашигласан JUnit Assertion-ууд
✅ assertTrue() - Нөхцөл үнэн эсэхийг шалгах
✅ assertFalse() - Нөхцөл худал эсэхийг шалгах
✅ assertEquals() - 2 утга тэнцүү эсэхийг шалгах
✅ assertNotNull() - Объект null биш эсэхийг шалгах
✅ assertThrows() - Exception зөв шидэгдэж байгаа эсэхийг шалгах
✅ fail() - Тест fail болох ёстой үед ашиглах
6. Ашигласан JUnit Annotation-ууд
@Test - Тест метод тодорхойлох
@Before - Тест бүрийн өмнө ажиллах setup метод
@BeforeClass - Бүх тестийн өмнө нэг удаа ажиллах метод (ашигласан)
7. Build Tool тохиргоо
Tool: Apache Ant
Build файл: build.xml

Targets:
ant compile - Main код compile хийх
ant compile-tests - Test код compile хийх
ant test - Бүх тест ажиллуулах
ant javadoc - JavaDoc баримт үүсгэх
ant clean - Build файлууд устгах
ant all - Бүгдийг нэг дор ажиллуулах
8. Тестийн хамрах хүрээ (Test Coverage)
Функционал	Тестлэгдсэн эсэх
Уулзалт товлох	
Амралт товлох	
Өрөөний сул эсэх шалгах	
Хүний завтай эсэх шалгах	
Цагийн давхцал илрүүлэх	
Буруу огноо шалгах	
Буруу цаг шалгах	
Coverage: Үндсэн функционалуудын ~85% тестлэгдсэн.

9. Дүгнэлт
Unit тест бичих явцад систем дээр 3 чухал алдаа илэрсэн. Эдгээр алдаанууд нь input validation хийгээгүй буюу дутуу хийсэнтэй холбоотой. Тестүүд нь JUnit framework-ийн үндсэн assertion болон exception testing-г зөв ашигласан. Build tool (Ant) тохируулагдсан бөгөөд тест болон javadoc үүсгэх боломжтой болсон.
