PGDMP                         {        	   detection    15.2    15.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16398 	   detection    DATABASE     }   CREATE DATABASE detection WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'French_Morocco.1252';
    DROP DATABASE detection;
                postgres    false            �            1259    16433    admin    TABLE     M   CREATE TABLE public.admin (
    username text NOT NULL,
    password text
);
    DROP TABLE public.admin;
       public         heap    postgres    false            �            1259    16455    information    TABLE     2  CREATE TABLE public.information (
    id integer NOT NULL,
    date_en date DEFAULT CURRENT_DATE NOT NULL,
    heure time without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    emotion character varying(255) NOT NULL,
    age character varying(255) NOT NULL,
    sexe character varying(255) NOT NULL
);
    DROP TABLE public.information;
       public         heap    postgres    false            �            1259    16454    information_id_seq    SEQUENCE     �   CREATE SEQUENCE public.information_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.information_id_seq;
       public          postgres    false    216                       0    0    information_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.information_id_seq OWNED BY public.information.id;
          public          postgres    false    215            i           2604    16458    information id    DEFAULT     p   ALTER TABLE ONLY public.information ALTER COLUMN id SET DEFAULT nextval('public.information_id_seq'::regclass);
 =   ALTER TABLE public.information ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    216    216            �          0    16433    admin 
   TABLE DATA           3   COPY public.admin (username, password) FROM stdin;
    public          postgres    false    214   W                  0    16455    information 
   TABLE DATA           M   COPY public.information (id, date_en, heure, emotion, age, sexe) FROM stdin;
    public          postgres    false    216   }                  0    0    information_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.information_id_seq', 88, true);
          public          postgres    false    215            m           2606    16439    admin admin_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (username);
 :   ALTER TABLE ONLY public.admin DROP CONSTRAINT admin_pkey;
       public            postgres    false    214            o           2606    16464    information information_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.information
    ADD CONSTRAINT information_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.information DROP CONSTRAINT information_pkey;
       public            postgres    false    216            �      x�KL����L�\1z\\\ 4�          �  x��սN�@��z�-���7;p�F[��dc�»�(˜C��'�a�=���ub]1�wI:)�e�~}�gs��po���<4>�Ͽ�lKlQ���Na����9b��F�M�zb�r;���T9T�F��U9h�O���c�nǢv�XԎYԎYԎY�.��1�6G���Ț�buI��T�۱U��X]B�E�=��?�6�,�]sRlN�mn:Y����hu�*V'��	j�,j�,jG*���r��a��u�y�^lps�쀦��^��JG�[��_.ߕM
+
�k;~Q�=)lQX�o�RA{������Ư�d��+
�1
�-tsT-���z{	�-���j�-���Ym���/(Zb/���ɢ�͋E�ļ��۟U�v(���nu��������~�)     