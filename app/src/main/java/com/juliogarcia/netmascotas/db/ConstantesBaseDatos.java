package com.juliogarcia.netmascotas;

/**
 * Created by anahisalgado on 04/05/16.
 */
public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_CONTACTS           = "mascota";
    public static final String TABLE_CONTACTS_ID        = "id";
    public static final String TABLE_CONTACTS_NOMBRE    = "nombre";
    public static final String TABLE_CONTACTS_FOTO      = "foto";

    public static final String TABLE_LIKES_CONTACT = "mascota_likes";
    public static final String TABLE_LIKES_CONTACT_ID = "id";
    public static final String TABLE_LIKES_CONTACT_ID_mascota = "id_mascota";
    public static final String TABLE_LIKES_CONTACT_NUMERO_LIKES = "numero_likes";
}
