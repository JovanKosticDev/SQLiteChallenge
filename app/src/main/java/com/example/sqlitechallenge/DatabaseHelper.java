package com.example.sqlitechallenge;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "library";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlStatement = "CREATE TABLE books (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, author VARCHAR, image_url TEXT, description TEXT);";
        db.execSQL(sqlStatement);

        initDatabase(db);
    }

    private void initDatabase(SQLiteDatabase db){
        ContentValues firstBook = new ContentValues();
        firstBook.put("name", "Das Geheimnis von Zimmer 622");
        firstBook.put("author", "Joel Dicker");
        firstBook.put("image_url", "https://exlibris.azureedge.net/covers/9783/4920/7090/4/9783492070904xxl.jpg");
        firstBook.put("description", "Eine dunkle Nacht im Dezember, ein Mord im vornehmen Hotel Palace in den Schweizer Alpen. Doch die Ermittlungen der Polizei verlaufen im Sand, der Fall wird nie aufgeklärt. ");

        db.insert("books", null, firstBook);

        ContentValues secondBook = new ContentValues();
        secondBook.put("name", "Der Schatten über dem Dorf");
        secondBook.put("author", "Arno Camenish");
        secondBook.put("image_url", "https://exlibris.azureedge.net/covers/9783/9060/5080/5/9783906050805xxl.jpg");
        secondBook.put("description", "Arno Camenisch erzählt in seinem Roman von einem Dorf in Graubünden, das von einer Tragödie überschattet wird. Die Tragödie geschah eineinhalb Jahre, bevor der Erzähler auf die Welt kam. Davon handelt dieses Buch, es ist Arno Camenisch persönlichstes Buch, in einem berührenden Ton und mit grosser Klarheit erzählt Arno Camenisch vom Leben und vom Tod und von den Menschen, die von uns gingen und die wir weiter im Herzen tragen.");

        db.insert("books", null, secondBook);

        ContentValues thirdBook = new ContentValues();
        thirdBook.put("name", "Bridgerton Der Duke und Ich");
        thirdBook.put("author", "Julia Quinn");
        thirdBook.put("image_url", "https://exlibris.azureedge.net/covers/9783/7499/5120/8/9783749951208xxl.jpg");
        thirdBook.put("description", "Bridgerton: Die Inspiration zur Netflix-Serie Als Daphne Bridgerton ihren Namen in der Kolumne von Lady Whistledown liest, kümmert es sie nicht besonders. Aber ihre Mutter drängt sie, endlich einen Ehemann zu finden, bevor ihr Ruf in dieser Ballsaison völlig dahin ist. Daphne schließt einen Pakt mit Simon Basset, dem heiratsunwilligen Duke of Hastings: Indem er ihr den Hof macht, erscheint der umschwärmte Aristokrat vergeben. Sie dagegen rückt gesellschaftlich in den Mittelpunkt und entflieht den Kuppelversuchen ihrer Mutter. Ein prickelndes Spiel beginnt - bis Daphne erkennt, dass nur einem Mann ihr Herz gehört: Simon! ");

        db.insert("books", null, thirdBook);

        ContentValues fourthBook = new ContentValues();
        fourthBook.put("name", "Hard Land");
        fourthBook.put("author", "Benedict Wells");
        fourthBook.put("image_url", "https://exlibris.azureedge.net/covers/9783/2570/7148/1/9783257071481xxl.jpg");
        fourthBook.put("description", "Missouri, 1985: Um vor den Problemen zu Hause zu fliehen, nimmt der fünfzehnjährige Sam einen Ferienjob in einem alten Kino an. Und einen magischen Sommer lang ist alles auf den Kopf gestellt. Er findet Freunde, verliebt sich und entdeckt die Geheimnisse seiner Heimatstadt. Zum ersten Mal ist er kein unscheinbarer Außenseiter mehr. Bis etwas passiert, das ihn zwingt, erwachsen zu werden.");

        db.insert("books", null, fourthBook);

        ContentValues fifthBook = new ContentValues();
        fifthBook.put("name", "VATI");
        fifthBook.put("author", "Monika Helfer");
        fifthBook.put("image_url", "https://exlibris.azureedge.net/covers/9783/4462/6917/0/9783446269170xxl.jpg");
        fifthBook.put("description", "Monika Helfer schreibt fort, was sie mit ihrem Bestseller Die Bagage begonnen hat: ihre eigene Familiengeschichte. Ein Mann mit Beinprothese, ein Abwesender, ein Witwer, ein Pensionär, ein Literaturliebhaber. Monika Helfer umkreist das Leben ihres Vaters und erzählt von ihrer eigenen Kindheit und Jugend. Von dem vielen Platz und der Bibliothek im Kriegsopfer-Erholungsheim in den Bergen, von der Armut und den beengten Lebensverhältnissen. Von dem, was sie weiß über ihren Vater, was sie über ihn in Erfahrung bringen kann. Mit großer Wahrhaftigkeit entsteht ein Roman über das Aufwachsen in schwierigen Verhältnissen, eine Suche nach der eigenen Herkunft. Ein Erinnerungsbuch, das sanft von Existenziellem berichtet und schmerzhaft im Erinnern bleibt. Ja, alles ist gut geworden. Auf eine bösartige Weise ist alles gut geworden.");

        db.insert("books", null, fifthBook);

        ContentValues sixthBook = new ContentValues();
        sixthBook.put("name", "Langnauer Gift");
        sixthBook.put("author", "Peter Beutler");
        sixthBook.put("image_url", "https://exlibris.azureedge.net/covers/9783/7408/0950/8/9783740809508xxl.jpg");
        sixthBook.put("description", "Langnau, 1925. Der Arzt Wendolin Roder und seine Assistentin Laura Borelli werden zu einer lebenslangen Freiheitsstrafe verurteilt. Sie werden beschuldigt, Roders Frau Linda vergiftet zu haben. Sechs Jahre später kommt der Freispruch im Revisionsprozess. Weder ihre Schuld noch ihre Unschuld konnte bewiesen werden. Als Roder kurz vor seinem Tod Besuch von einem ehemaligen Ermittler bekommt, stellt sich heraus, dass er nicht der Einzige ist, der weiss, wer das Verbrechen begangen hat - und massive Versäumnisse der Untersuchungsbehörden kommen ans Licht");

        db.insert("books", null, sixthBook);

        ContentValues seventhBook = new ContentValues();
        seventhBook.put("name", "Das Parfum");
        seventhBook.put("author", "Patrick Suesskind");
        seventhBook.put("image_url", "https://exlibris.azureedge.net/covers/9783/2572/2800/7/9783257228007xxl.jpg");
        seventhBook.put("description", "Ein rares Meisterwerk zeitgenössischer Prosa, eine dicht gesponnene, psychologisch raffiniert umgesetzte Erzählung, die an die frühen Stücke von Patricia Highsmith erinnert, in ihrer Kunstfertigkeit aber an die Novellistik großer europäischer Erzähltradition anknüpft.");

        db.insert("books", null, seventhBook);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
