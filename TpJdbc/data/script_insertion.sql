INSERT INTO "PUBLIC"."CLIENT"
( "ID_CLIENT", "NOM", "PRENOM" )
VALUES ( 1, 'T-Family', 'Titi'),
( 2, 'T-Family', 'Toto'),
( 3, 'T-Family', 'Tata'),
( 4, 'T-Family', 'Tete'),
( 5, 'T-Family', 'Tutu');


INSERT INTO "PUBLIC"."ARTICLE"
( "ID_ARTICLE", "NOM", "PRIX" )
VALUES ( 1, '1er titre.mp3', 2.50),
( 2, '2eme titre.mp3', 2.20),
( 3, '3eme titre.mp3', 3),
( 4, '4eme titre.mp3', 2.40),
( 5, '5eme titre.mp3', 1.50);



select next value for facture_sequence from article