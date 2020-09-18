import java.util.Scanner;
public class tarea{
	
	public static Scanner lector = new Scanner (System.in);
	
		public static void main (String[] args){
			
			int blackW,whiteW,paintW; // Estos son contadores que usaré para definir si hay un tipo de obra o pintura dentro del primer for().
			
			double totalWork; // Esta variable funciona en funcion de la sumatoria de las constantes WORKBLACK,WORKWHITE y PAINTING (Dependiendo de la analogía a la tabla de verdad).
			
			System.out.println("Ingrese la cantidad de materiales asignados (cantidad por tipo): ");
		
			int totalMaterial = lector.nextInt(); // 
			
			String [] material = new String[totalMaterial]; 
			
			double [] priceHomecenter = new double[totalMaterial];
			
			double [] priceFcentro = new double[totalMaterial];
			
			double [] priceFbarrio = new double[totalMaterial];
			
			double [] amountProduct = new double[totalMaterial]; // La cantidad de cada producto (ejemplo: 10 ladrillos)
			 
			Utility [] work = new Utility[totalMaterial]; // Declaramos la variable work como arreglo con el enum utility.
			
			Ubication placeUbi; // Declaramos la variable placeUbi (lugar de ubicacion para el domicilio) con enum ubication.
			
			System.out.println("Ingrese el nombre de cada material (por tipo): ");
			
			blackW=whiteW=paintW=0;
			
				for (int i=0;i<totalMaterial;i++){      // Este FOR se usa para ingresa el nombre de materia, cantidad y tipo de utilizacion.
					
					lector.nextLine();
					
					System.out.println("Material #"+(i+1));
					
					material[i]=lector.nextLine();
					
					System.out.println("Ingrese cantidad a llevar de este material: ");
					
					amountProduct[i]=lector.nextInt();
					
					System.out.println("Tipo de utilizacion (1.Obra negra /2. Obra blanca /3. Pintura)");
					
					int joinUtility=lector.nextInt();
					work[i]=null;
					
					switch (joinUtility){
						case 1:
							work[i]=Utility.OBRANEGRA;
						case 2:
							work[i]=Utility.OBRABLANCA;
						case 3:
							work[i]=Utility.PINTURA;
					}
					
					if (work[i]==Utility.OBRANEGRA){
						blackW++;
					}if (work[i]==Utility.OBRABLANCA){
						whiteW++;
					}if (work[i]==Utility.PINTURA){
						paintW++;
					}
				}
						
					totalWork=0;														 //TABLA DE VERDAD:
																										
				if (blackW>0 && whiteW>0 && paintW>0){     // V - V - V 
					totalWork=4880000;  
				}if (blackW>0 && whiteW>0 && paintW==0){   // V - V - F
					totalWork=3900000;
				}if (blackW>0 && whiteW==0 && paintW==0){   // V - F - F
					totalWork=1300000;
				}if (blackW==0 && whiteW==0 && paintW>0){   // F - F - V
					totalWork=980000;
				}if (blackW==0 && whiteW>0 && paintW>0){   // F - V - V
					totalWork=3580000;
				}if (blackW>0 && whiteW==0 && paintW>0){   // V - F - V
					totalWork=2280000;
				}if (blackW==0 && whiteW>0 && paintW==0){   // F - V - F
					totalWork=2600000;
				}
				
			System.out.println("Ahora bien, hay 3 lugares donde se pueden conseguir dichos materiales. Dichos lugares son: Homecenter, Ferreteria del Centro y Ferreteria del Barrio. ");
				
			System.out.println("Primero, digite los valores de compra por unidad de los materiales en HOMECENTER: ");
				
				double hcPayment=0;
				double multiHC=0;
				
				for (int i=0;i<totalMaterial;i++){                                          //PRECIO MATERIAL HOMECENTER
					
					System.out.println("Precio del material ("+material[i]+"):");
					
					priceHomecenter[i]=lector.nextDouble();
					
					multiHC = priceHomecenter[i]*amountProduct[i];
					
					hcPayment=hcPayment+multiHC;
					
				}
			
			System.out.println("Segundo, digite los valores de compra por unidad de los materiales en FERRETERIA DEL CENTRO");
			
				double fcPayment=0;
				double multiFC=0;
			
				for (int i=0;i<totalMaterial;i++){                                          //PRECIO MATERIAL FERRETERIA DEL CENTRO
					
					System.out.println("Precio del material ("+material[i]+"):");
					
					priceFcentro[i]=lector.nextDouble();
					
					multiFC=priceFcentro[i]*amountProduct[i];
					
					fcPayment=fcPayment+multiFC;
					
				}
				
			System.out.println("Tercero, digite los valores de compra por unidad de los materiales en FERRETERIA DEL BARRIO");
			
				double fbPayment=0;
				double multiFB=0;
				for (int i=0;i<totalMaterial;i++){                                         //PRECIO MATERIAL FERRETERIA DEL BARRIO
					
					System.out.println("Precio del material ("+material[i]+"):");
					
					priceFbarrio[i]=lector.nextDouble();
					
					multiFB=priceFbarrio[i]*amountProduct[i];
					
					fbPayment=fbPayment+(priceFbarrio[i]*amountProduct[i]);
					
				}
				
			System.out.println("Desea solicitar domicilio: Si (1) / No(0)");
			
				int option = lector.nextInt();
			
				if (option==1){
					
					System.out.println("Defina la ubicacion de entrega (1. Norte /2. Centro /3. Sur): ");
					
					int joinUbication=lector.nextInt();
					
					placeUbi=null;
					
					switch (joinUbication){
						case 1:
							placeUbi=Ubication.NORTE;
								break;
						case 2:
							placeUbi=Ubication.CENTRO;
								break;
						case 3:
							placeUbi=Ubication.SUR;
								break;
					}
					
					if (placeUbi==Ubication.NORTE){              // DOMICILIO EN EL NORTE      <--------------------------------NORTE
						
						if(hcPayment>300000){                                                  // TOTAL COMPRA HOMECENTER
				
								System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork));
						
						}if(hcPayment<=80000){
							
							System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork+120000));
							
							}else{
									
									System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork+28000));
									
								}
								
							if(fcPayment>300000){                                                  //TOTAL COMPRA FERRETERIA DEL CENTRO
				
								System.out.println("El total a pagar en ferreteria del centro es: "+(fcPayment+totalWork));
						
						}if(fcPayment<=80000){
							
							System.out.println("El total a pagar en ferreteria del centro es: "+(fcPayment+totalWork+120000));
							
							}else{
									
									System.out.println("El total a pagar en ferreteria del centro es: "+(fcPayment+totalWork+28000));
									
								}
								
							if(fbPayment>300000){                                                 //TOTAL COMPRA FERRETERIA DEL BARRIO
				
								System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork));
						
						}if(fbPayment<=80000){
							
							System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork+120000));
							
							}else{
									
									System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork+28000));
									
								}
					
						}
						if(placeUbi==Ubication.CENTRO){                     // DOMICILIO EN EL CENTRO     <------------------------CENTRO
							
							if(hcPayment>300000){                                               // TOTAL COMPRA HOMECENTER
				
								System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork));
						
							}if(hcPayment<=80000){
							
								System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork+50000));
							
								}else{
									
									System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork));
									
								}
								
							if(fcPayment>300000){                                              //TOTAL COMPRA FERRETERIA DEL CENTRO
				
								System.out.println("El total a pagar en ferreteria del centro es: "+(fcPayment+totalWork));
						
						}if(fcPayment<=80000){
							
							System.out.println("El total a pagar en ferreteria del centro es: "+(fcPayment+totalWork+50000));
							
							}else{
									
									System.out.println("El total a pagar en ferreteria del centro es: "+(fcPayment+totalWork));
									
								}
								
							if(fbPayment>300000){                                             //TOTAL COMPRA FERRETERIA DEL BARRIO
				
								System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork));
						
						}if(fbPayment<=80000){
							
							System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork+50000));
							
							}else{
									
									System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork));
									
								}
							
						}
						if(placeUbi==Ubication.SUR){                        // DOMICILIO EN EL SUR   <---------------------------------SUR
							
							if(hcPayment>300000){    // TOTAL COMPRA HOMECENTER
				
								System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork));
						
						}if(hcPayment<=80000){
							
							System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork+120000));
							
							}else{
									
									System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork+55000));
									
								}
								
							if(fcPayment>300000){     //TOTAL COMPRA FERRETERIA DEL CENTRO
				
								System.out.println("El total a pagar en ferreteria del centro es: "+(fcPayment+totalWork));
						
						}if(fcPayment<=80000){
							
							System.out.println("El total a pagar en ferreteria del centro es: "+(fcPayment+totalWork+120000));
							
							}else{
									
									System.out.println("El total a pagar en ferreteria del centro es: "+(fcPayment+totalWork+55000));
									
								}
								
							if(fbPayment>300000){    //TOTAL COMPRA FERRETERIA DEL BARRIO
				
								System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork));
						
						}if(fbPayment<=80000){
							
							System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork+120000));
							
							}else{
									
									System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork+55000));
									
								}
							
						}
						
				}else{
					System.out.println("El total a pagar en Homecenter es: "+(hcPayment+totalWork));
					System.out.println("El total a pagar en ferreteria del barrio es: "+(fcPayment+totalWork));
					System.out.println("El total a pagar en ferreteria del barrio es: "+(fbPayment+totalWork));
				}
				
				double [] bestPrice= new double[totalMaterial];
				
				
				
		}
}