MelodyNote implements Iterable - Книга с песнями

(!!!ВНИМАНИЕ!!! Пока не был вызван метод iterator() не может быть использованна для добавления песен !!!ВНИМАНИЕ!!!)

Конструкторы:
1)public MelodyNote()
2)public MelodyNote(Song [] songs)

Методы:
1)public void addSong(Song song) - добавляет песню в книгу
2)public Iterator iterator() - отдаёт объект типа Iterator


Song implements Iterable - Песни, которые содержат ноты

Конструкторы:
1)public Song()
2)public Song(@NotNull Note[] notes1)

Методы:
1)public void addNote(@NotNull Note note) - добавляет в песню ноту
2)public void addNote(@NotNull Note [] notes1) - добавляет в песню массив нот
3)public void addInMelodyNote(@NotNull MelodyNote parent) - добавляет песню в книгу
4)public void changeMood(Note.Mood mood,int start, int end) - меняет лад нот с позиции start по позицию end(не включительно)
5)public void changeMood(Note.Mood mood,int start) - меняет лад нот с позиции start и до конца песни
6)public void changeMood(Note.Mood mood) - меняет лад нот во всей песне
7)public boolean compare(Song song,int start, int end) - сравнивает песни с позиции start по позицию end(не включительно)
8)public boolean compare(Song song,int start) - сравнивает песни с позиции start до конца строки
9)public boolean compare(Song song) - сравнивает песни
10)public void play() - выводит в консоль все ноты в песне. Мажорные с большой буквы, минорные - с маленькой
11)public ArrayList<Page> intoPages(int numNotesOnPage) - переводит песню в коллекцию из страниц
12)public Iterator iterator() - отдаёт объект типа Iterator


Page extends Song - Песня с ограниченным количеством нот

Конструкторы:
1)public Page(int numNotesOnPage) 

Методы:
1)public Page getPreviousPage() - получить предыдущую страницу с песней (null если первая)
2)public Page getNextPage() - получить следующую страницу с песней (null если последняя)
3)public int getNumberPage() - получить номер страницы


Note - нота

Константы:
Mood MAJOR = Mood.major;
Mood MINOR = Mood.minor;
enum Mood {major,minor}
enum NoteSignEnum {c,d,e,f,g,a,b}
NoteSignEnum C = NoteSignEnum.c;//до
NoteSignEnum D = NoteSignEnum.d;//ре
NoteSignEnum E = NoteSignEnum.e;//ми
NoteSignEnum F = NoteSignEnum.f;//фа
NoteSignEnum G = NoteSignEnum.g;//соль
NoteSignEnum A = NoteSignEnum.a;//ля
NoteSignEnum B = NoteSignEnum.b;//си

Конструкторы:
1)public Note(@NotNull NoteSignEnum noteSign)
2)public Note(@NotNull NoteSignEnum noteSign, @NotNull Mood musicalMood)

Методы:
1)public void setMusicalMood(@NotNull Mood musicalMood) - поставить ноту в указанный лад
2)public char getNoteSign() - получить знак ноты
3)public Mood getMusicalMood() - получить лад
4)public byte compare(@NotNull Note note) - сравнить ноты. '-1' если нота меньше, '0' если равны и '1' если больше. Нота меньше если она левее. Если ноты на одной позиции, то меньше минорная нота

В классе Main можно найти примеры использования
