PGDMP                         w            teste    12.0    12.0 '    2           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            3           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            4           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            5           1262    16445    teste    DATABASE     �   CREATE DATABASE teste WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE teste;
                postgres    false            �            1259    24703 
   encomendas    TABLE     �   CREATE TABLE public.encomendas (
    id integer NOT NULL,
    fornecedor character varying(255),
    id_produto integer,
    qnt integer,
    valor double precision,
    data date
);
    DROP TABLE public.encomendas;
       public         heap    postgres    false            �            1259    24701    encomendas_id_seq    SEQUENCE     �   CREATE SEQUENCE public.encomendas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.encomendas_id_seq;
       public          postgres    false    205            6           0    0    encomendas_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.encomendas_id_seq OWNED BY public.encomendas.id;
          public          postgres    false    204            �            1259    24719    endereco    TABLE       CREATE TABLE public.endereco (
    id integer NOT NULL,
    usuario character varying(255),
    pais character varying(255),
    estado character varying(255),
    cidade character varying(255),
    bairro character varying(255),
    rua character varying(255),
    numero integer
);
    DROP TABLE public.endereco;
       public         heap    postgres    false            �            1259    24717    endereco_id_seq    SEQUENCE     �   CREATE SEQUENCE public.endereco_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.endereco_id_seq;
       public          postgres    false    209            7           0    0    endereco_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.endereco_id_seq OWNED BY public.endereco.id;
          public          postgres    false    208            �            1259    24695    estoque    TABLE     �   CREATE TABLE public.estoque (
    id integer NOT NULL,
    nome character varying(255),
    valor_encomenda double precision,
    valor_venda double precision,
    qnt integer
);
    DROP TABLE public.estoque;
       public         heap    postgres    false            �            1259    24693    estoque_id_seq    SEQUENCE     �   CREATE SEQUENCE public.estoque_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.estoque_id_seq;
       public          postgres    false    203            8           0    0    estoque_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.estoque_id_seq OWNED BY public.estoque.id;
          public          postgres    false    202            �            1259    24730    usuarios    TABLE     �   CREATE TABLE public.usuarios (
    id integer NOT NULL,
    login character varying(255),
    senha character varying(255),
    email character varying(255),
    endereco integer,
    tipo character varying(255)
);
    DROP TABLE public.usuarios;
       public         heap    postgres    false            �            1259    24728    usuarios_id_seq    SEQUENCE     �   CREATE SEQUENCE public.usuarios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.usuarios_id_seq;
       public          postgres    false    211            9           0    0    usuarios_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.usuarios_id_seq OWNED BY public.usuarios.id;
          public          postgres    false    210            �            1259    24711    vendas    TABLE     �   CREATE TABLE public.vendas (
    id integer NOT NULL,
    cliente character varying(255),
    id_produto integer,
    qnt integer,
    valor double precision,
    data date
);
    DROP TABLE public.vendas;
       public         heap    postgres    false            �            1259    24709    vendas_id_seq    SEQUENCE     �   CREATE SEQUENCE public.vendas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.vendas_id_seq;
       public          postgres    false    207            :           0    0    vendas_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.vendas_id_seq OWNED BY public.vendas.id;
          public          postgres    false    206            �
           2604    24706    encomendas id    DEFAULT     n   ALTER TABLE ONLY public.encomendas ALTER COLUMN id SET DEFAULT nextval('public.encomendas_id_seq'::regclass);
 <   ALTER TABLE public.encomendas ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204    205            �
           2604    24722    endereco id    DEFAULT     j   ALTER TABLE ONLY public.endereco ALTER COLUMN id SET DEFAULT nextval('public.endereco_id_seq'::regclass);
 :   ALTER TABLE public.endereco ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    209    208    209            �
           2604    24698 
   estoque id    DEFAULT     h   ALTER TABLE ONLY public.estoque ALTER COLUMN id SET DEFAULT nextval('public.estoque_id_seq'::regclass);
 9   ALTER TABLE public.estoque ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202    203            �
           2604    24733    usuarios id    DEFAULT     j   ALTER TABLE ONLY public.usuarios ALTER COLUMN id SET DEFAULT nextval('public.usuarios_id_seq'::regclass);
 :   ALTER TABLE public.usuarios ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    211    211            �
           2604    24714 	   vendas id    DEFAULT     f   ALTER TABLE ONLY public.vendas ALTER COLUMN id SET DEFAULT nextval('public.vendas_id_seq'::regclass);
 8   ALTER TABLE public.vendas ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    207    206    207            )          0    24703 
   encomendas 
   TABLE DATA           R   COPY public.encomendas (id, fornecedor, id_produto, qnt, valor, data) FROM stdin;
    public          postgres    false    205   �)       -          0    24719    endereco 
   TABLE DATA           Z   COPY public.endereco (id, usuario, pais, estado, cidade, bairro, rua, numero) FROM stdin;
    public          postgres    false    209   *       '          0    24695    estoque 
   TABLE DATA           N   COPY public.estoque (id, nome, valor_encomenda, valor_venda, qnt) FROM stdin;
    public          postgres    false    203   �+       /          0    24730    usuarios 
   TABLE DATA           K   COPY public.usuarios (id, login, senha, email, endereco, tipo) FROM stdin;
    public          postgres    false    211   Y,       +          0    24711    vendas 
   TABLE DATA           K   COPY public.vendas (id, cliente, id_produto, qnt, valor, data) FROM stdin;
    public          postgres    false    207   -       ;           0    0    encomendas_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.encomendas_id_seq', 21, true);
          public          postgres    false    204            <           0    0    endereco_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.endereco_id_seq', 30, true);
          public          postgres    false    208            =           0    0    estoque_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.estoque_id_seq', 19, true);
          public          postgres    false    202            >           0    0    usuarios_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.usuarios_id_seq', 23, true);
          public          postgres    false    210            ?           0    0    vendas_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.vendas_id_seq', 13, true);
          public          postgres    false    206            �
           2606    24708    encomendas encomendas_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.encomendas
    ADD CONSTRAINT encomendas_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.encomendas DROP CONSTRAINT encomendas_pkey;
       public            postgres    false    205            �
           2606    24727    endereco endereco_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.endereco DROP CONSTRAINT endereco_pkey;
       public            postgres    false    209            �
           2606    24700    estoque estoque_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT estoque_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.estoque DROP CONSTRAINT estoque_pkey;
       public            postgres    false    203            �
           2606    24738    usuarios usuarios_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public            postgres    false    211            �
           2606    24716    vendas vendas_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.vendas
    ADD CONSTRAINT vendas_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.vendas DROP CONSTRAINT vendas_pkey;
       public            postgres    false    207            )   }   x�U�;� ��z��3�x��q�x��/��6��E����q~������ɾѶX��6�$;��/��8�ѧh*���Z�K,9M�1Mji�5]rǂ�]̸����U����̓�+���|QX      -   p  x���A��0E��)r�"���^vZt]�]t��W$��$",ǘ� �Xi2��,,��Ts �+gz(�|�o�d\���~�R���˄���S���}}����e�Ϝ
����F)9�R�Ҽ�e�N���>~���yB��}��ݭ�%�Ԙ_XIS9//�����ъ5-�?ܔA#�X�zV��5Dp�4��NB�:� ��u����筕l���+�2�ؒU�F�H�b�d@ǻ�{����l�2�(��5�T��ԍ���x����S�6l�Ӵ�����<�Ӣ�}�8�5~p~��v� ~6f���B��x�[��N�U����;�}-�����Xn!aL��*�m�������ι���      '   �   x�5�A�0ϛ�D��ҋ�H"�����>�MPe�౽k�(y���ӡQ�G����X�m�r|^�d��
�Λ$�c �%N�q�m�U���P�-,�*;E��s��Fa����sz��s�H�-Q�X�T�Yє{u�C��O�l��4/<��}E�~�"����q�J�
'<~      /   �   x�u��
�0E�3S��Mw���?pS�(�&���GA���	��=\f,c	��;aj�I��,4��%y��y5O
����M��Ջ��D��/��%`��J�T	���-�K@�de�Ŕ�J�E�p$Yct;<����n:����tl15]��?f� ����      +   u   x�e�K�0�5�K"�?w�.ʢR�U������P:^��z��B`2&a���%[
8K�2Y���k]
��69Swՠ})�3����P��-(�B�_\���f��=�|D,\��SJ#�B�     