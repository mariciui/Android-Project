/**
    Aceasta clasa reprezinta Baza de Date a aplicatiei, aici se creeaza tabelele, popularile si interogarile
 */


package com.example.bookgo.Controller.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.bookgo.Model.Cazare;
import com.example.bookgo.Model.Client;
import com.example.bookgo.Model.Furnizor;
import com.example.bookgo.Model.Oferte;
import com.example.bookgo.Model.Rezervare;
import com.example.bookgo.Model.Transport;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {
    //baza de date
    public static final String DATABASE_NAME="bookGo.db";

    //tabel1 Client
    public static final String TABLE_NAME1="Client";
    public static final String COL11="id_Client";
    public static final String COL12="userLog";
    public static final String COL13="parola";
    public static final String COL14="nume";
    public static final String COL15="prenume";
    public static final String COL16="rang";
    public static final String COL17="puncte";
    public static final String COL18="data_nasterii";

    //tabel2 Furnizor
    public static final String TABLE_NAME2="Furnizor";
    public static final String COL21="id_Furnizor";
    public static final String COL22="userLog";
    public static final String COL23="parola";
    public static final String COL24="nume";
    public static final String COL25="prenume";
    public static final String COL26="data_nasterii";

    //tabel3 Transport
    public static final String TABLE_NAME3="Transport";
    public static final String COL31="id_Transport";
    public static final String COL32="id_Furnizor";
    public static final String COL33="locatieStart";
    public static final String COL34="locatieStop";
    public static final String COL35="pret";
    public static final String COL36="dataStart";
    public static final String COL37="dataStop";
    public static final String COL38="tipTransport";

    //tabel4 Cazare
    public static final String TABLE_NAME4="Cazare";
    public static final String COL41="id_Cazare";
    public static final String COL42="id_Furnizor";
    public static final String COL43="locatie";
    public static final String COL44="pret";
    public static final String COL45="dataStart";
    public static final String COL46="dataStop";
    public static final String COL47="tipCazare";

    //tabel5 Rezervari
    public static final String TABLE_NAME5="Rezervare";
    public static final String COL51="id_Rezervare";
    public static final String COL52="id_Cazare";
    public static final String COL53="id_Transport";
    public static final String COL54="id_Client";
    public static final String COL55="id_Oferta";
    public static final String COL56="dataCheckIn";
    public static final String COL57="dataCheckOut";

    //tabel6 Oferte
    public static final String TABLE_NAME6="Oferte";
    public static final String COL61="id_Oferta";
    public static final String COL62="id_Cazare";
    public static final String COL63="id_Transport";
    public static final String COL64="id_Furnizor";





    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null,1, null);
        SQLiteDatabase db = this.getWritableDatabase();
    }
//aici se creaza tabelele
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME1 + "( id_Client INTEGER PRIMARY KEY AUTOINCREMENT , userLog TEXT NOT NULL, parola TEXT NOT NULL, nume TEXT NOT NULL, prenume TEXT NOT NULL, rang TEXT NOT NULL, puncte INTEGER NOT NULL, data_nasterii DATE NOT NULL)");
        db.execSQL("create table " + TABLE_NAME2 + "(id_Furnizor INTEGER PRIMARY KEY AUTOINCREMENT, userLog TEXT NOT NULL, parola TEXT NOT NULL, nume TEXT NOT NULL, prenume TEXT NOT NULL, data_nasterii DATE NOT NULL)");
        db.execSQL("create table " + TABLE_NAME3 + "(id_Transport INTEGER PRIMARY KEY AUTOINCREMENT,id_Furnizor int(11) NOT NULL, locatieStart TEXT NOT NULL, locatieStop TEXT NOT NULL, pret int(11) NOT NULL, dataStart datetime NOT NULL, dataStop datetime NOT NULL, tipTransport TEXT NOT NULL)");
        db.execSQL("create table " + TABLE_NAME4 + "(id_Cazare INTEGER PRIMARY KEY AUTOINCREMENT, id_Furnizor int(11) NOT NULL, locatie varchar(32) NOT NULL, pret int(11) NOT NULL, dataStart TEXT NOT NULL, dataStop TEXT NOT NULL, tipCazare varchar(32) NOT NULL)");
        db.execSQL("create table " + TABLE_NAME5 + "(id_Rezervare INTEGER PRIMARY KEY AUTOINCREMENT, id_Cazare int(11), id_Transport  int(11), id_Client int(11) NOT NULL, id_Oferta int(11) , dataCheckIn TEXT, dataCheckOut TEXT)");
        db.execSQL("create table " + TABLE_NAME6 + "(id_Oferta INTEGER PRIMARY KEY AUTOINCREMENT, id_Cazare int(11), id_Transport  int(11), id_Furnizor int(11) NOT NULL)");


    }
// aici se verifica daca exista tabelele
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME4);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME5);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME6);


        onCreate(db);
    }
//inserare client
    public boolean insertClient(Client  client){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL12,client.getUserLog());
        contentValues.put(COL13,client.getParola());
        contentValues.put(COL14,client.getNume());
        contentValues.put(COL15,client.getPrenume());
        contentValues.put(COL16,"user");
        contentValues.put(COL17,100);
        contentValues.put(COL18, client.getDataNasterii());

        long result=db.insert(TABLE_NAME1,null,contentValues);
        if (result==-1){
            return false;
        }
        else
            return true;

    }
//inserare furnizor
    public boolean insertFurnizor(Furnizor furnizor){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL22,furnizor.getUserLog());
        contentValues.put(COL23,furnizor.getParola());
        contentValues.put(COL24,furnizor.getNume());
        contentValues.put(COL25,furnizor.getPrenume());
        contentValues.put(COL26, furnizor.getDataNsterii());

        long result=db.insert(TABLE_NAME2,null,contentValues);
        if (result==-1){
            return false;
        }
        else
            return true;

    }
//inserare rezervare
    public  boolean insertRezervare(Rezervare rezervare){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(COL52,rezervare.getCazare().getIdCazare());
        contentValues.put(COL53,rezervare.getTransport().getIdTransport());
        contentValues.put(COL54,rezervare.getClient().getIdClient());
        contentValues.put(COL55,rezervare.getOferte().getIdOferta());
        contentValues.put(COL56," ");
        contentValues.put(COL57," ");

        long result=db.insert(TABLE_NAME5,null,contentValues);
        if (result==-1){
            return false;
        }
        else
            return true;
    }
//identificare client dupa user si parola
    public Client findClientByUserLog(String user){
        Client client=new Client();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(" SELECT id_Client,parola FROM Client WHERE userLog='"+user+"'",null);

        if(cursor.moveToFirst()) {
            while (cursor.isAfterLast() == false) {
                client.setIdClient(cursor.getInt(cursor.getColumnIndex(COL11)));
                client.setParola(cursor.getString(cursor.getColumnIndex(COL13)));
                cursor.moveToNext();
            }
            return client;
        }else{
            Log.e("Error not found","userul nu poate fi gasit sau baza de date este goala!!!");
            return client;
        }

    }
//identificare furnizor dupa user si parola
    public Furnizor findFunizorByUserLog(String user){
        Furnizor furnizor=new Furnizor();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(" SELECT id_Furnizor,parola FROM Furnizor WHERE userLog='"+user+"'",null);

        if(cursor.moveToFirst()) {
            while (cursor.isAfterLast() == false) {

                furnizor.setIdFurnizor(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COL21))));
                furnizor.setParola(cursor.getString(cursor.getColumnIndex(COL23)));
                cursor.moveToNext();
            }
            return furnizor;
        }else{
            Log.e("Error not found","userul nu poate fi gasit sau baza de date este goala!!!");
            return furnizor;
        }

    }
//identificare cazare dupa ID
    public Cazare findCazareID(int id){
        Cazare cazare=new Cazare();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(" SELECT locatie,pret,dataStart,dataStop,tipCazare FROM Cazare WHERE id_Cazare='"+id+"'",null);

        if(cursor.moveToFirst()) {
            while (cursor.isAfterLast() == false) {
                cazare.setIdCazare(id);
                cazare.setLocatie(cursor.getString(cursor.getColumnIndex(COL43)));
                cazare.setPret(cursor.getInt(cursor.getColumnIndex(COL44)));
                cazare.setDataStart(cursor.getString(cursor.getColumnIndex(COL45)));
                cazare.setDataStop(cursor.getString(cursor.getColumnIndex(COL46)));
                cazare.setTipCazare(cursor.getString(cursor.getColumnIndex(COL47)));
                cursor.moveToNext();
            }
            return cazare;
        }else{
            Log.e("Error not found","userul nu poate fi gasit sau baza de date este goala!!!");
            return cazare;
        }

    }
//identificare transport dupa ID
    public Transport findTransportID(int id){
        Transport transport=new Transport();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(" SELECT pret,dataStart,dataStop,tipTransport FROM Transport WHERE id_Transport='"+id+"'",null);

        if(cursor.moveToFirst()) {
            while (cursor.isAfterLast() == false) {
                transport.setIdTransport(id);
                transport.setPret(cursor.getInt(cursor.getColumnIndex(COL35)));
                transport.setDataStart(cursor.getString(cursor.getColumnIndex(COL36)));
                transport.setDataStop(cursor.getString(cursor.getColumnIndex(COL37)));
                transport.setTipTransport(cursor.getString(cursor.getColumnIndex(COL38)));
                cursor.moveToNext();
            }
            return transport;
        }else{
            Log.e("Error not found","userul nu poate fi gasit sau baza de date este goala!!!");
            return transport;
        }

    }
//afisare toate cazarile
    public String showAllCazare(){
        SQLiteDatabase db=this.getReadableDatabase();
        String[]columns=new String[]{COL41,COL43,COL44,COL47};
        Cursor c=db.query(TABLE_NAME4,columns,null,null,null,null,null);
        String result="";

        int idc=c.getColumnIndex(COL41);
        int ilocatie=c.getColumnIndex(COL43);
        int ipret=c.getColumnIndex(COL44);
        int iTip=c.getColumnIndex(COL47);
        for(c.moveToFirst(); !c.isAfterLast();c.moveToNext())
        {
            result=result + c.getString(idc)+ " " +c.getString(ilocatie)+ " " +c.getString(ipret) + " " +c.getString(iTip)+ "\n";
        }

        return result;
    }
//afisare toate transporturile
    public String showAllTransport(){
        SQLiteDatabase db=this.getReadableDatabase();
        String[]columns=new String[]{COL31,COL33,COL34,COL35,COL36,COL37,COL38};
        Cursor c=db.query(TABLE_NAME3,columns,null,null,null,null,null);
        String result="";

        int idc=c.getColumnIndex(COL31);
        int ilocatieStart=c.getColumnIndex(COL33);
        int ilocatieStop=c.getColumnIndex(COL34);
        int ipret=c.getColumnIndex(COL35);
        int iDataStart=c.getColumnIndex(COL36);
        int iDataStop=c.getColumnIndex(COL37);
        int iTip=c.getColumnIndex(COL38);
        for(c.moveToFirst(); !c.isAfterLast();c.moveToNext())
        {
            result=result + c.getString(idc)+ " " +c.getString(ilocatieStart)+ " " +c.getString(ilocatieStop) + " " +c.getString(ipret);
            result=result + c.getString(iDataStart)+ " " +c.getString(iDataStop)+ " " +c.getString(iTip)+ "\n";
        }

        return result;
    }
//cautare dupa locatie
    public String getLocatie(String locatie){
        SQLiteDatabase db=this.getReadableDatabase();
        String result="";

        Cursor c=db.rawQuery(" SELECT id_Cazare,locatie,pret,tipCazare FROM Cazare WHERE locatie='"+locatie+"'",null);


        while (c.moveToNext()) {
            int id=c.getInt(c.getColumnIndex(COL41));
            String locatir=c.getString(c.getColumnIndex(COL43));
            int pret=c.getInt(c.getColumnIndex(COL44));
            String tip=c.getString(c.getColumnIndex(COL47));

            result=result + id+ " " +locatie+ " " +pret + " " +tip+ "\n";
        }

        return result;
    }
//inserare cazare pentru furnizor
    public boolean insertCazare(Cazare cazare){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL42,cazare.getIdFurnizor());
        contentValues.put(COL43, cazare.getLocatie());
        contentValues.put(COL44,cazare.getPret());
        contentValues.put(COL45, cazare.getDataStart());
        contentValues.put(COL46, cazare.getDataStop());
        contentValues.put(COL47,cazare.getTipCazare());

        long result = db.insert(TABLE_NAME4,null,contentValues);
        if (result == -1){
            return false;
        }
        else return true;
    }
//inserare oferta pentru furnizor
    public boolean insertOferta(Oferte oferte){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL62,oferte.getCazare());
        contentValues.put(COL63,oferte.getTransport());
        contentValues.put(COL64,oferte.getFurnizor());

        long result = db.insert(TABLE_NAME6,null,contentValues);
        if (result == -1){
            return false;
        }
        else return true;

    }
//inserare transport pentru furnizor
    public boolean insertTransport(Transport transport){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL32,transport.getIdFurnizor());
        contentValues.put(COL33, transport.getLocatieStart());
        contentValues.put(COL34,transport.getLocatieStop());
        contentValues.put(COL35, transport.getPret());
        contentValues.put(COL36,transport.getDataStart());
        contentValues.put(COL37,transport.getDataStop());
        contentValues.put(COL38,transport.getTipTransport());

        long result = db.insert(TABLE_NAME3,null,contentValues);
        if (result == -1){
            return false;
        }
        else return true;
    }
//vizualizare lista cazare furnizor
    public ArrayList<Cazare> listaCazareFurnizor(int idFurnizor){
        ArrayList<Cazare> cazares=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        String result="";

        Cursor c=db.rawQuery(" SELECT id_Cazare,id_Furnizor,locatie,pret,tipCazare FROM Cazare WHERE id_Furnizor='"+idFurnizor+"'",null);


        while (c.moveToNext()) {
            int id=c.getInt(c.getColumnIndex(COL41));
            int idF=c.getInt(c.getColumnIndex(COL42));
            String locatir=c.getString(c.getColumnIndex(COL43));
            int pret=c.getInt(c.getColumnIndex(COL44));
            String tip=c.getString(c.getColumnIndex(COL47));

            Cazare cazare=new Cazare(idFurnizor,locatir,pret,"","",tip);
            cazare.setIdCazare(id);
            cazares.add(cazare);

        }


        return cazares;
    }
//vizualizare lista transport furnizor
    public ArrayList<Transport> listaTransportFurnizor(int idFurnizor){
        ArrayList<Transport> transports=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        String result="";

        Cursor c=db.rawQuery(" SELECT id_Transport,id_Furnizor,locatieStart,locatieStop,pret,tipTransport FROM Transport WHERE id_Furnizor='"+idFurnizor+"'",null);


        while (c.moveToNext()) {
            int id=c.getInt(c.getColumnIndex(COL31));
            int idF=c.getInt(c.getColumnIndex(COL32));
            String locatieStart=c.getString(c.getColumnIndex(COL33));
            String locatieStop=c.getString(c.getColumnIndex(COL34));
            int pret=c.getInt(c.getColumnIndex(COL35));
            String tip=c.getString(c.getColumnIndex(COL38));

            Transport transport=new Transport(idFurnizor,locatieStart,locatieStop,pret,"","",tip);
            transport.setIdTransport(id);
            transports.add(transport);

        }


        return transports;
    }
//afisare cazari
    public ArrayList<Cazare> listaCazare(){
        ArrayList<Cazare> cazares=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        String result="";

        Cursor c=db.rawQuery(" SELECT id_Cazare,id_Furnizor,locatie,pret,dataStart,dataStop,tipCazare FROM Cazare",null);


        while (c.moveToNext()) {
            int id=c.getInt(c.getColumnIndex(COL41));
            int idF=c.getInt(c.getColumnIndex(COL42));
            String locatir=c.getString(c.getColumnIndex(COL43));
            int pret=c.getInt(c.getColumnIndex(COL44));
            String dataStart=c.getString(c.getColumnIndex(COL45));
            String dataStop=c.getString(c.getColumnIndex(COL46));
            String tip=c.getString(c.getColumnIndex(COL47));

            Cazare cazare=new Cazare(idF,locatir,pret,dataStart,dataStop,tip);
            cazare.setIdCazare(id);
            cazares.add(cazare);

        }


        return cazares;
    }
//afisare transport
    public ArrayList<Transport> listaTransport(){
        ArrayList<Transport> transports=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        String result="";

        Cursor c=db.rawQuery(" SELECT id_Transport,id_Furnizor,locatieStart,locatieStop,pret,dataStart,dataStop,tipTransport FROM Transport ",null);


        while (c.moveToNext()) {
            int id=c.getInt(c.getColumnIndex(COL31));
            int idF=c.getInt(c.getColumnIndex(COL32));
            String locatieStart=c.getString(c.getColumnIndex(COL33));
            String locatieStop=c.getString(c.getColumnIndex(COL34));
            int pret=c.getInt(c.getColumnIndex(COL35));
            String dataStart=c.getString(c.getColumnIndex(COL36));
            String dataStop=c.getString(c.getColumnIndex(COL37));
            String tip=c.getString(c.getColumnIndex(COL38));

            Transport transport=new Transport(idF,locatieStart,locatieStop,pret,dataStart,dataStop,tip);
            transport.setIdTransport(id);
            transports.add(transport);

        }


        return transports;
    }
//afisare lista oferte
    public ArrayList<Oferte> listaOferte(){
        ArrayList<Oferte> ofertes=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor c=db.rawQuery(" SELECT id_Oferta, id_Cazare, id_Transport, id_Furnizor FROM Oferte ",null);


        while (c.moveToNext()) {
            int id=c.getInt(c.getColumnIndex(COL61));
            int idC=c.getInt(c.getColumnIndex(COL62));
            int idT=c.getInt(c.getColumnIndex(COL63));
            int idF=c.getInt(c.getColumnIndex(COL64));

            Oferte oferte=new Oferte(idC,idT,idF);
            oferte.setIdOferta(id);
            ofertes.add(oferte);

        }


        return ofertes;
    }




}
