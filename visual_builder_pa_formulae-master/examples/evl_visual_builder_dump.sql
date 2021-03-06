- -   M y S Q L   d u m p   1 0 . 1 3     D i s t r i b   5 . 7 . 1 9 ,   f o r   W i n 3 2   ( A M D 6 4 )  
 - -  
 - -   H o s t :   l o c a l h o s t         D a t a b a s e :   e v l _ v i s u a l _ b u i l d e r  
 - -   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  
 - -   S e r v e r   v e r s i o n 	 5 . 7 . 1 9  
  
 / * ! 4 0 1 0 1   S E T   @ O L D _ C H A R A C T E R _ S E T _ C L I E N T = @ @ C H A R A C T E R _ S E T _ C L I E N T   * / ;  
 / * ! 4 0 1 0 1   S E T   @ O L D _ C H A R A C T E R _ S E T _ R E S U L T S = @ @ C H A R A C T E R _ S E T _ R E S U L T S   * / ;  
 / * ! 4 0 1 0 1   S E T   @ O L D _ C O L L A T I O N _ C O N N E C T I O N = @ @ C O L L A T I O N _ C O N N E C T I O N   * / ;  
 / * ! 4 0 1 0 1   S E T   N A M E S   u t f 8   * / ;  
 / * ! 4 0 1 0 3   S E T   @ O L D _ T I M E _ Z O N E = @ @ T I M E _ Z O N E   * / ;  
 / * ! 4 0 1 0 3   S E T   T I M E _ Z O N E = ' + 0 0 : 0 0 '   * / ;  
 / * ! 4 0 0 1 4   S E T   @ O L D _ U N I Q U E _ C H E C K S = @ @ U N I Q U E _ C H E C K S ,   U N I Q U E _ C H E C K S = 0   * / ;  
 / * ! 4 0 0 1 4   S E T   @ O L D _ F O R E I G N _ K E Y _ C H E C K S = @ @ F O R E I G N _ K E Y _ C H E C K S ,   F O R E I G N _ K E Y _ C H E C K S = 0   * / ;  
 / * ! 4 0 1 0 1   S E T   @ O L D _ S Q L _ M O D E = @ @ S Q L _ M O D E ,   S Q L _ M O D E = ' N O _ A U T O _ V A L U E _ O N _ Z E R O '   * / ;  
 / * ! 4 0 1 1 1   S E T   @ O L D _ S Q L _ N O T E S = @ @ S Q L _ N O T E S ,   S Q L _ N O T E S = 0   * / ;  
  
 - -  
 - -   T a b l e   s t r u c t u r e   f o r   t a b l e   ` c o n t e x t `  
 - -  
  
 D R O P   T A B L E   I F   E X I S T S   ` c o n t e x t ` ;  
 / * ! 4 0 1 0 1   S E T   @ s a v e d _ c s _ c l i e n t           =   @ @ c h a r a c t e r _ s e t _ c l i e n t   * / ;  
 / * ! 4 0 1 0 1   S E T   c h a r a c t e r _ s e t _ c l i e n t   =   u t f 8   * / ;  
 C R E A T E   T A B L E   ` c o n t e x t `   (  
     ` i d `   i n t ( 1 1 )   N O T   N U L L   A U T O _ I N C R E M E N T ,  
     ` n a m e `   v a r c h a r ( 2 5 5 )   D E F A U L T   N U L L ,  
     P R I M A R Y   K E Y   ( ` i d ` )  
 )   E N G I N E = I n n o D B   A U T O _ I N C R E M E N T = 6   D E F A U L T   C H A R S E T = l a t i n 1 ;  
 / * ! 4 0 1 0 1   S E T   c h a r a c t e r _ s e t _ c l i e n t   =   @ s a v e d _ c s _ c l i e n t   * / ;  
  
 - -  
 - -   D u m p i n g   d a t a   f o r   t a b l e   ` c o n t e x t `  
 - -  
  
 L O C K   T A B L E S   ` c o n t e x t `   W R I T E ;  
 / * ! 4 0 0 0 0   A L T E R   T A B L E   ` c o n t e x t `   D I S A B L E   K E Y S   * / ;  
 I N S E R T   I N T O   ` c o n t e x t `   V A L U E S   ( 1 , ' O p e r a t i o n ' ) , ( 2 , ' M e s s a g e ' ) , ( 3 , ' C o m p o n e n t ' ) , ( 4 , ' C l a s s i f i e r ' ) , ( 5 , ' N o d e ' ) ;  
 / * ! 4 0 0 0 0   A L T E R   T A B L E   ` c o n t e x t `   E N A B L E   K E Y S   * / ;  
 U N L O C K   T A B L E S ;  
  
 - -  
 - -   T a b l e   s t r u c t u r e   f o r   t a b l e   ` d o `  
 - -  
  
 D R O P   T A B L E   I F   E X I S T S   ` d o ` ;  
 / * ! 4 0 1 0 1   S E T   @ s a v e d _ c s _ c l i e n t           =   @ @ c h a r a c t e r _ s e t _ c l i e n t   * / ;  
 / * ! 4 0 1 0 1   S E T   c h a r a c t e r _ s e t _ c l i e n t   =   u t f 8   * / ;  
 C R E A T E   T A B L E   ` d o `   (  
     ` i d `   i n t ( 1 1 )   N O T   N U L L   A U T O _ I N C R E M E N T ,  
     ` n a m e `   v a r c h a r ( 2 5 5 )   D E F A U L T   N U L L ,  
     ` b o d y `   v a r c h a r ( 5 0 0 0 )   D E F A U L T   N U L L ,  
     P R I M A R Y   K E Y   ( ` i d ` )  
 )   E N G I N E = I n n o D B   A U T O _ I N C R E M E N T = 9   D E F A U L T   C H A R S E T = l a t i n 1 ;  
 / * ! 4 0 1 0 1   S E T   c h a r a c t e r _ s e t _ c l i e n t   =   @ s a v e d _ c s _ c l i e n t   * / ;  
  
 - -  
 - -   D u m p i n g   d a t a   f o r   t a b l e   ` d o `  
 - -  
  
 L O C K   T A B L E S   ` d o `   W R I T E ;  
 / * ! 4 0 0 0 0   A L T E R   T A B L E   ` d o `   D I S A B L E   K E Y S   * / ;  
 I N S E R T   I N T O   ` d o `   V A L U E S   ( 1 , ' m o v e T o N e w O w n e r D e p l o y e d O n N e w N o d e ' , ' b o d y ' ) , ( 2 , ' m o v e T o N e w O w n e r D e p l o y e d O n N e a r L e s s U s e d N o d e ' , ' b o d y ' ) , ( 3 , ' m o v e T o L e s s C r i t i c a l O w n e r ' , ' b o d y ' ) , ( 4 , ' d e c o m p o s i t i o n ' , ' b o d y ' ) , ( 5 , ' m o v e T o N e w C o m p o n e n t D e p l o y e d O n N e w N o d e ' , ' b o d y ' ) , ( 6 , ' m o v e T o N e w C o m p o n e n t D e p l o y e d O n N e a r L e s s U s e d N o d e ' , ' b o d y ' ) , ( 7 , ' r e d e p l o y O n N e a r L e s s U s e d N o d e ' , ' b o d y ' ) , ( 8 , ' m o v e T o L e s s C r i t i c a l C o m p o n e n t ' , ' b o d y ' ) ;  
 / * ! 4 0 0 0 0   A L T E R   T A B L E   ` d o `   E N A B L E   K E Y S   * / ;  
 U N L O C K   T A B L E S ;  
  
 - -  
 - -   T a b l e   s t r u c t u r e   f o r   t a b l e   ` d o _ c o n t e x t `  
 - -  
  
 D R O P   T A B L E   I F   E X I S T S   ` d o _ c o n t e x t ` ;  
 / * ! 4 0 1 0 1   S E T   @ s a v e d _ c s _ c l i e n t           =   @ @ c h a r a c t e r _ s e t _ c l i e n t   * / ;  
 / * ! 4 0 1 0 1   S E T   c h a r a c t e r _ s e t _ c l i e n t   =   u t f 8   * / ;  
 C R E A T E   T A B L E   ` d o _ c o n t e x t `   (  
     ` d o _ i d `   i n t ( 1 1 )   N O T   N U L L ,  
     ` c o n t e x t _ i d `   i n t ( 1 1 )   N O T   N U L L ,  
     P R I M A R Y   K E Y   ( ` d o _ i d ` , ` c o n t e x t _ i d ` ) ,  
     K E Y   ` c o n t e x t _ i d `   ( ` c o n t e x t _ i d ` ) ,  
     C O N S T R A I N T   ` d o _ c o n t e x t _ i b f k _ 1 `   F O R E I G N   K E Y   ( ` d o _ i d ` )   R E F E R E N C E S   ` d o `   ( ` i d ` ) ,  
     C O N S T R A I N T   ` d o _ c o n t e x t _ i b f k _ 2 `   F O R E I G N   K E Y   ( ` c o n t e x t _ i d ` )   R E F E R E N C E S   ` c o n t e x t `   ( ` i d ` )  
 )   E N G I N E = I n n o D B   D E F A U L T   C H A R S E T = l a t i n 1 ;  
 / * ! 4 0 1 0 1   S E T   c h a r a c t e r _ s e t _ c l i e n t   =   @ s a v e d _ c s _ c l i e n t   * / ;  
  
 - -  
 - -   D u m p i n g   d a t a   f o r   t a b l e   ` d o _ c o n t e x t `  
 - -  
  
 L O C K   T A B L E S   ` d o _ c o n t e x t `   W R I T E ;  
 / * ! 4 0 0 0 0   A L T E R   T A B L E   ` d o _ c o n t e x t `   D I S A B L E   K E Y S   * / ;  
 I N S E R T   I N T O   ` d o _ c o n t e x t `   V A L U E S   ( 1 , 1 ) , ( 2 , 1 ) , ( 3 , 1 ) , ( 4 , 1 ) , ( 7 , 1 ) , ( 5 , 3 ) , ( 6 , 3 ) , ( 7 , 3 ) , ( 8 , 3 ) , ( 5 , 5 ) , ( 6 , 5 ) , ( 7 , 5 ) , ( 8 , 5 ) ;  
 / * ! 4 0 0 0 0   A L T E R   T A B L E   ` d o _ c o n t e x t `   E N A B L E   K E Y S   * / ;  
 U N L O C K   T A B L E S ;  
  
 - -  
 - -   T a b l e   s t r u c t u r e   f o r   t a b l e   ` f `  
 - -  
  
 D R O P   T A B L E   I F   E X I S T S   ` f ` ;  
 / * ! 4 0 1 0 1   S E T   @ s a v e d _ c s _ c l i e n t           =   @ @ c h a r a c t e r _ s e t _ c l i e n t   * / ;  
 / * ! 4 0 1 0 1   S E T   c h a r a c t e r _ s e t _ c l i e n t   =   u t f 8   * / ;  
 C R E A T E   T A B L E   ` f `   (  
     ` i d `   i n t ( 1 1 )   N O T   N U L L   A U T O _ I N C R E M E N T ,  
     ` n a m e `   v a r c h a r ( 2 5 5 )   D E F A U L T   N U L L ,  
     ` r e t u r n _ b o o l `   t i n y i n t ( 1 )   D E F A U L T   N U L L ,  
     ` i s U n a r y `   t i n y i n t ( 1 )   D E F A U L T   N U L L ,  
     P R I M A R Y   K E Y   ( ` i d ` )  
 )   E N G I N E = I n n o D B   A U T O _ I N C R E M E N T = 7   D E F A U L T   C H A R S E T = l a t i n 1 ;  
 / * ! 4 0 1 0 1   S E T   c h a r a c t e r _ s e t _ c l i e n t   =   @ s a v e d _ c s _ c l i e n t   * / ;  
  
 - -  
 - -   D u m p i n g   d a t a   f o r   t a b l e   ` f `  
 - -  
  
 L O C K   T A B L E S   ` f `   W R I T E ;  
 / * ! 4 0 0 0 0   A L T E R   T A B L E   ` f `   D I S A B L E   K E Y S   * / ;  
 I N S E R T   I N T O   ` f `   V A L U E S   ( 1 , ' F _ p r o b E x e c ' , 1 , 1 ) , ( 2 , ' F _ r e s D e m a n d ' , 0 , 1 ) , ( 3 , ' F _ T ' , 0 , 1 ) , ( 4 , ' F _ m a x Q L ' , 0 , 1 ) , ( 5 , ' F _ m a x H w U t i l ' , 0 , 1 ) , ( 6 , ' F _ R T ' , 0 , 1 ) ;  
 / * ! 4 0 0 0 0   A L T E R   T A B L E   ` f `   E N A B L E   K E Y S   * / ;  
 U N L O C K   T A B L E S ;  
  
 - -  
 - -   T a b l e   s t r u c t u r e   f o r   t a b l e   ` f _ c o n t e x t `  
 - -  
  
 D R O P   T A B L E   I F   E X I S T S   ` f _ c o n t e x t ` ;  
 / * ! 4 0 1 0 1   S E T   @ s a v e d _ c s _ c l i e n t           =   @ @ c h a r a c t e r _ s e t _ c l i e n t   * / ;  
 / * ! 4 0 1 0 1   S E T   c h a r a c t e r _ s e t _ c l i e n t   =   u t f 8   * / ;  
 C R E A T E   T A B L E   ` f _ c o n t e x t `   (  
     ` f _ i d `   i n t ( 1 1 )   N O T   N U L L ,  
     ` c o n t e x t _ i d `   i n t ( 1 1 )   N O T   N U L L ,  
     ` f _ b o d y `   v a r c h a r ( 5 0 0 0 )   D E F A U L T   N U L L ,  
     P R I M A R Y   K E Y   ( ` f _ i d ` , ` c o n t e x t _ i d ` ) ,  
     K E Y   ` c o n t e x t _ i d `   ( ` c o n t e x t _ i d ` ) ,  
     C O N S T R A I N T   ` f _ c o n t e x t _ i b f k _ 1 `   F O R E I G N   K E Y   ( ` f _ i d ` )   R E F E R E N C E S   ` f `   ( ` i d ` ) ,  
     C O N S T R A I N T   ` f _ c o n t e x t _ i b f k _ 2 `   F O R E I G N   K E Y   ( ` c o n t e x t _ i d ` )   R E F E R E N C E S   ` c o n t e x t `   ( ` i d ` )  
 )   E N G I N E = I n n o D B   D E F A U L T   C H A R S E T = l a t i n 1 ;  
 / * ! 4 0 1 0 1   S E T   c h a r a c t e r _ s e t _ c l i e n t   =   @ s a v e d _ c s _ c l i e n t   * / ;  
  
 - -  
 - -   D u m p i n g   d a t a   f o r   t a b l e   ` f _ c o n t e x t `  
 - -  
  
 L O C K   T A B L E S   ` f _ c o n t e x t `   W R I T E ;  
 / * ! 4 0 0 0 0   A L T E R   T A B L E   ` f _ c o n t e x t `   D I S A B L E   K E Y S   * / ;  
 I N S E R T   I N T O   ` f _ c o n t e x t `   V A L U E S   ( 1 , 1 , ' b o d y ' ) , ( 1 , 3 , ' b o d y ' ) , ( 2 , 1 , ' b o d y ' ) , ( 2 , 3 , ' b o d y ' ) , ( 3 , 1 , ' b o d y ' ) , ( 4 , 5 , ' b o d y ' ) , ( 5 , 1 , ' b o d y ' ) , ( 5 , 5 , ' b o d y ' ) , ( 6 , 3 , ' b o d y ' ) ;  
 / * ! 4 0 0 0 0   A L T E R   T A B L E   ` f _ c o n t e x t `   E N A B L E   K E Y S   * / ;  
 U N L O C K   T A B L E S ;  
  
 - -  
 - -   T a b l e   s t r u c t u r e   f o r   t a b l e   ` f _ f `  
 - -  
  
 D R O P   T A B L E   I F   E X I S T S   ` f _ f ` ;  
 / * ! 4 0 1 0 1   S E T   @ s a v e d _ c s _ c l i e n t           =   @ @ c h a r a c t e r _ s e t _ c l i e n t   * / ;  
 / * ! 4 0 1 0 1   S E T   c h a r a c t e r _ s e t _ c l i e n t   =   u t f 8   * / ;  
 C R E A T E   T A B L E   ` f _ f `   (  
     ` f _ i d `   i n t ( 1 1 )   N O T   N U L L ,  
     ` f _ i d _ t o _ c o m p a r e `   i n t ( 1 1 )   N O T   N U L L ,  
     P R I M A R Y   K E Y   ( ` f _ i d ` , ` f _ i d _ t o _ c o m p a r e ` ) ,  
     K E Y   ` f _ i d _ t o _ c o m p a r e `   ( ` f _ i d _ t o _ c o m p a r e ` ) ,  
     C O N S T R A I N T   ` f _ f _ i b f k _ 1 `   F O R E I G N   K E Y   ( ` f _ i d ` )   R E F E R E N C E S   ` f `   ( ` i d ` ) ,  
     C O N S T R A I N T   ` f _ f _ i b f k _ 2 `   F O R E I G N   K E Y   ( ` f _ i d _ t o _ c o m p a r e ` )   R E F E R E N C E S   ` f `   ( ` i d ` )  
 )   E N G I N E = I n n o D B   D E F A U L T   C H A R S E T = l a t i n 1 ;  
 / * ! 4 0 1 0 1   S E T   c h a r a c t e r _ s e t _ c l i e n t   =   @ s a v e d _ c s _ c l i e n t   * / ;  
  
 - -  
 - -   D u m p i n g   d a t a   f o r   t a b l e   ` f _ f `  
 - -  
  
 L O C K   T A B L E S   ` f _ f `   W R I T E ;  
 / * ! 4 0 0 0 0   A L T E R   T A B L E   ` f _ f `   D I S A B L E   K E Y S   * / ;  
 / * ! 4 0 0 0 0   A L T E R   T A B L E   ` f _ f `   E N A B L E   K E Y S   * / ;  
 U N L O C K   T A B L E S ;  
  
 - -  
 - -   T a b l e   s t r u c t u r e   f o r   t a b l e   ` f _ t h r e s h o l d s `  
 - -  
  
 D R O P   T A B L E   I F   E X I S T S   ` f _ t h r e s h o l d s ` ;  
 / * ! 4 0 1 0 1   S E T   @ s a v e d _ c s _ c l i e n t           =   @ @ c h a r a c t e r _ s e t _ c l i e n t   * / ;  
 / * ! 4 0 1 0 1   S E T   c h a r a c t e r _ s e t _ c l i e n t   =   u t f 8   * / ;  
 C R E A T E   T A B L E   ` f _ t h r e s h o l d s `   (  
     ` f _ i d `   i n t ( 1 1 )   N O T   N U L L ,  
     ` t h r e s h o l d s _ i d `   i n t ( 1 1 )   N O T   N U L L ,  
     P R I M A R Y   K E Y   ( ` f _ i d ` , ` t h r e s h o l d s _ i d ` ) ,  
     K E Y   ` t h r e s h o l d s _ i d `   ( ` t h r e s h o l d s _ i d ` ) ,  
     C O N S T R A I N T   ` f _ t h r e s h o l d s _ i b f k _ 1 `   F O R E I G N   K E Y   ( ` f _ i d ` )   R E F E R E N C E S   ` f `   ( ` i d ` ) ,  
     C O N S T R A I N T   ` f _ t h r e s h o l d s _ i b f k _ 2 `   F O R E I G N   K E Y   ( ` t h r e s h o l d s _ i d ` )   R E F E R E N C E S   ` t h r e s h o l d s `   ( ` i d ` )  
 )   E N G I N E = I n n o D B   D E F A U L T   C H A R S E T = l a t i n 1 ;  
 / * ! 4 0 1 0 1   S E T   c h a r a c t e r _ s e t _ c l i e n t   =   @ s a v e d _ c s _ c l i e n t   * / ;  
  
 - -  
 - -   D u m p i n g   d a t a   f o r   t a b l e   ` f _ t h r e s h o l d s `  
 - -  
  
 L O C K   T A B L E S   ` f _ t h r e s h o l d s `   W R I T E ;  
 / * ! 4 0 0 0 0   A L T E R   T A B L E   ` f _ t h r e s h o l d s `   D I S A B L E   K E Y S   * / ;  
 I N S E R T   I N T O   ` f _ t h r e s h o l d s `   V A L U E S   ( 4 , 1 ) , ( 5 , 2 ) , ( 2 , 3 ) , ( 2 , 4 ) , ( 3 , 5 ) , ( 6 , 6 ) ;  
 / * ! 4 0 0 0 0   A L T E R   T A B L E   ` f _ t h r e s h o l d s `   E N A B L E   K E Y S   * / ;  
 U N L O C K   T A B L E S ;  
  
 - -  
 - -   T a b l e   s t r u c t u r e   f o r   t a b l e   ` t h r e s h o l d s `  
 - -  
  
 D R O P   T A B L E   I F   E X I S T S   ` t h r e s h o l d s ` ;  
 / * ! 4 0 1 0 1   S E T   @ s a v e d _ c s _ c l i e n t           =   @ @ c h a r a c t e r _ s e t _ c l i e n t   * / ;  
 / * ! 4 0 1 0 1   S E T   c h a r a c t e r _ s e t _ c l i e n t   =   u t f 8   * / ;  
 C R E A T E   T A B L E   ` t h r e s h o l d s `   (  
     ` i d `   i n t ( 1 1 )   N O T   N U L L   A U T O _ I N C R E M E N T ,  
     ` n a m e `   v a r c h a r ( 2 5 5 )   D E F A U L T   N U L L ,  
     ` v a l u e `   f l o a t   D E F A U L T   N U L L ,  
     P R I M A R Y   K E Y   ( ` i d ` )  
 )   E N G I N E = I n n o D B   A U T O _ I N C R E M E N T = 7   D E F A U L T   C H A R S E T = l a t i n 1 ;  
 / * ! 4 0 1 0 1   S E T   c h a r a c t e r _ s e t _ c l i e n t   =   @ s a v e d _ c s _ c l i e n t   * / ;  
  
 - -  
 - -   D u m p i n g   d a t a   f o r   t a b l e   ` t h r e s h o l d s `  
 - -  
  
 L O C K   T A B L E S   ` t h r e s h o l d s `   W R I T E ;  
 / * ! 4 0 0 0 0   A L T E R   T A B L E   ` t h r e s h o l d s `   D I S A B L E   K E Y S   * / ;  
 I N S E R T   I N T O   ` t h r e s h o l d s `   V A L U E S   ( 1 , ' t h _ m a x Q L ' , 1 2 . 5 ) , ( 2 , ' t h _ m a x H w U t i l ' , 1 2 . 5 ) , ( 3 , ' t h _ m a x R e s D e m a n d ' , 1 2 . 5 ) , ( 4 , ' t h _ m i n R e s D e m a n d ' , 1 2 . 5 ) , ( 5 , ' t h _ S t h R e q ' , 1 2 . 5 ) , ( 6 , ' t h _ S r t R e q ' , 1 2 . 5 ) ;  
 / * ! 4 0 0 0 0   A L T E R   T A B L E   ` t h r e s h o l d s `   E N A B L E   K E Y S   * / ;  
 U N L O C K   T A B L E S ;  
 / * ! 4 0 1 0 3   S E T   T I M E _ Z O N E = @ O L D _ T I M E _ Z O N E   * / ;  
  
 / * ! 4 0 1 0 1   S E T   S Q L _ M O D E = @ O L D _ S Q L _ M O D E   * / ;  
 / * ! 4 0 0 1 4   S E T   F O R E I G N _ K E Y _ C H E C K S = @ O L D _ F O R E I G N _ K E Y _ C H E C K S   * / ;  
 / * ! 4 0 0 1 4   S E T   U N I Q U E _ C H E C K S = @ O L D _ U N I Q U E _ C H E C K S   * / ;  
 / * ! 4 0 1 0 1   S E T   C H A R A C T E R _ S E T _ C L I E N T = @ O L D _ C H A R A C T E R _ S E T _ C L I E N T   * / ;  
 / * ! 4 0 1 0 1   S E T   C H A R A C T E R _ S E T _ R E S U L T S = @ O L D _ C H A R A C T E R _ S E T _ R E S U L T S   * / ;  
 / * ! 4 0 1 0 1   S E T   C O L L A T I O N _ C O N N E C T I O N = @ O L D _ C O L L A T I O N _ C O N N E C T I O N   * / ;  
 / * ! 4 0 1 1 1   S E T   S Q L _ N O T E S = @ O L D _ S Q L _ N O T E S   * / ;  
  
 - -   D u m p   c o m p l e t e d   o n   2 0 1 7 - 1 0 - 0 1   1 9 : 4 7 : 4 7  
 