package clasesPropias;

public class HiddenPairs {
	public void hiddenPairs(Tablero t) {
		boolean res[];
		int n = t.getMida();
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				System.out.println(t.getValorTauler(i, j));
				if(t.getValorTauler(i, j) == 0){
					comprobarFila(t,i,j);
					comprobarColumna(t,i,j);
					comprobarRegion(t,i,j);
				}
			}
		}
	}

	private static void comprobarFila(Tablero t, int i, int j) {
		int n = t.getMida();
		int cont = 0;
		int cont2 = 9;
		for(int k = 0; k < n; ++k) {
			System.out.println("i: " + i +"k: "+k+ ",j: "+ j+ " -   "+ t.getValorTauler(i, k));
			if (k != j && t.getValorTauler(i, k) == 0) {	
				cont = 0;
				cont2 = 9;
				boolean res[] = t.getCandidatsTauler(i, j);	//candidatos del que analizamos
				boolean aux[] = t.getCandidatsTauler(i, k); //candidatos de aquel con el que comparamos
				boolean aux2[] = new boolean[10];			//candidatos de las casillas del ultimo recorrido
				/*System.out.println("Empieza: i: "+i+",j: "+j+",k: "+k);
				for(int ii=0; ii<n; ++ii){
					if(aux[ii]) System.out.print(" "+1);
					else System.out.print(" "+0);
				}

				System.out.println(" ");
				System.out.println(" ");

				for(int ii=0; ii<n; ++ii){
					if(aux2[ii]) System.out.print(" "+1);
					else System.out.print(" "+0);
				}

				System.out.println(" ");
				System.out.println(" ");

				for(int ii=0; ii<n; ++ii){
					if(res[ii]) System.out.print(" "+1);
					else System.out.print(" "+0);
				}

				System.out.println(" ");
				System.out.println(" ");
				 */
				for(int it = 1; it <= n; ++it) {
					if (res[it] && aux[it]) {
						aux2[it] = true;
					}
					else {
						aux2[it] = false;
						--cont2;
					}
				}

				System.out.println("Empieza: i: "+i+",j: "+j+",k: "+k+" cont2: "+ cont2);
				/*for(int ii=1; ii<=n; ++ii){
					if(aux2[ii]) System.out.print(" "+1);
					else System.out.print(" "+0);
				}*/

				System.out.println(" ");
				if (cont2>=2) {

					for(int it2 = 1; it2 <= n; ++it2) {
						if(it2-1 != j && it2-1 != k) {
							boolean aux3[] = t.getCandidatsTauler(i, it2-1);
							/*System.out.print(t.getValorTauler(it2-1, j)+": ");*
							for(int ii=1; ii<=n; ++ii){
								if(aux3[ii]) System.out.print(" "+1);
								else System.out.print(" "+0);
							}*/
							System.out.println(" ");
							for(int it3 = 1; it3 < n+1; ++it3) {
								if(aux2[it3] && aux3[it3]) aux2[it3] = false;
							}
						}
					}


					for(int last = 0; last < n; ++last) {
						if(aux2[last]) ++cont;
					}


					if(cont == 2) {
						System.out.println("PASO");
						t.setCandidatsTauler(i, j, aux2);
						t.setCandidatsTauler(i, k, aux2);
					}
				}
			}

		}
	}

	private static void comprobarColumna(Tablero t, int i, int j) {
		int n = t.getMida();
		int cont = 0;
		int cont2 = 9;
		for(int k = 0; k < n; ++k) {
			if (k != i && t.getValorTauler(k, j) == 0) {	
				cont = 0;
				cont2 = 9;
				boolean res[] = t.getCandidatsTauler(i, j);	//candidatos del que analizamos
				boolean aux[] = t.getCandidatsTauler(k, j); //candidatos de aquel con el que comparamos
				boolean aux2[] = new boolean[10];			//candidatos de las casillas del ultimo recorrido
				/*System.out.println("Empieza: i: "+i+",j: "+j+",k: "+k);
				for(int ii=0; ii<n; ++ii){
					if(aux[ii]) System.out.print(" "+1);
					else System.out.print(" "+0);
				}

				System.out.println(" ");
				System.out.println(" ");

				for(int ii=0; ii<n; ++ii){
					if(aux2[ii]) System.out.print(" "+1);
					else System.out.print(" "+0);
				}

				System.out.println(" ");
				System.out.println(" ");

				for(int ii=0; ii<n; ++ii){
					if(res[ii]) System.out.print(" "+1);
					else System.out.print(" "+0);
				}

				System.out.println(" ");
				System.out.println(" ");
				 */
				for(int it = 1; it <= n; ++it) {
					if (res[it] && aux[it]) {
						aux2[it] = true;
					}
					else {
						aux2[it] = false;
						--cont2;
					}
				}

				System.out.println("Empieza: i: "+i+",j: "+j+",k: "+k+" cont2: "+ cont2);
				for(int ii=1; ii<=n; ++ii){
					if(aux2[ii]) System.out.print(" "+1);
					else System.out.print(" "+0);
				}

				System.out.println(" ");
				if (cont2>=2) {

					for(int it2 = 1; it2 <= n; ++it2) {
						if(it2-1 != i && it2-1 != k) {
							boolean aux3[] = t.getCandidatsTauler(it2-1, j);
							System.out.print(t.getValorTauler(it2-1, j)+": ");
							for(int ii=1; ii<=n; ++ii){
								if(aux3[ii]) System.out.print(" "+1);
								else System.out.print(" "+0);
							}
							System.out.println(" ");
							for(int it3 = 1; it3 < n+1; ++it3) {
								if(aux2[it3] && aux3[it3]) aux2[it3] = false;
							}
						}
					}


					for(int last = 0; last < n; ++last) {
						if(aux2[last]) ++cont;
					}


					if(cont == 2) {
						System.out.println("PASO");
						t.setCandidatsTauler(i, j, aux2);
						t.setCandidatsTauler(k, j, aux2);
					}
				}
			}

		}
	}

	private static void comprobarRegion(Tablero t, int i, int j) {
		int n = t.getMida();
		int box_size = (int) Math.sqrt(n);
		int cont = 0;
		int cont2 = 9;
		for(int k=i/box_size*box_size; k<i/box_size*box_size+box_size; ++k){
			for (int l=j/box_size*box_size; l < j/box_size*box_size+box_size; ++l) {
				System.out.println("i: " + i +"k: "+k+ ",j: "+ j+ ",l: "+l+" -   "+ t.getValorTauler(i, k));
				if ((k != i || l != j) && t.getValorTauler(k, l) == 0) {	
					cont = 0;
					cont2 = 9;
					boolean res[] = t.getCandidatsTauler(i, j);	//candidatos del que analizamos
					boolean aux[] = t.getCandidatsTauler(k, l); //candidatos de aquel con el que comparamos
					boolean aux2[] = new boolean[10];			//candidatos de las casillas del ultimo recorrido
					System.out.println("Empieza: i: "+i+",j: "+j+",k: "+k);
					for(int ii=1; ii<=n; ++ii){
						if(aux[ii]) System.out.print(" "+1);
						else System.out.print(" "+0);
					}

					System.out.println(" ");
					System.out.println(" ");

					/*for(int ii=0; ii<n; ++ii){
					if(aux2[ii]) System.out.print(" "+1);
					else System.out.print(" "+0);
				}

				System.out.println(" ");
				System.out.println(" ");*/

					for(int ii=1; ii<=n; ++ii){
						if(res[ii]) System.out.print(" "+1);
						else System.out.print(" "+0);
					}

					System.out.println(" ");
					System.out.println(" ");

					for(int it = 1; it <= n; ++it) {
						if (res[it] && aux[it]) {
							aux2[it] = true;
						}
						else {
							aux2[it] = false;
							--cont2;
						}
					}

					System.out.println("Empieza: i: "+i+",j: "+j+",k: "+k+",l: "+l+" cont2: "+ cont2);
					for(int ii=1; ii<=n; ++ii){
						if(aux2[ii]) System.out.print(" "+1);
						else System.out.print(" "+0);
					}

					System.out.println(" ");
					if (cont2>=2) {

						for(int it2=(i/box_size*box_size); it2< i/box_size*box_size+box_size; ++it2){
							for (int it22=(j/box_size*box_size); it22 < j/box_size*box_size+box_size; ++it22) {
								if((it2 == i && it22 == j || (it2 == k && it22 == l))) {
									int a = 0;
								}
								else{
									boolean aux3[] = t.getCandidatsTauler(it2, it22);
									System.out.print(t.getValorTauler(it2, it22)+": ");
									for(int ii=1; ii<=n; ++ii){
										if(aux3[ii]) System.out.print(" "+1);
										else System.out.print(" "+0);
									}
									System.out.println(" ");
									for(int it3 = 1; it3 < n+1; ++it3) {
										if(aux2[it3] && aux3[it3]) aux2[it3] = false;
									}
								}
							}
						}

						for(int last = 0; last < n; ++last) {
							if(aux2[last]) ++cont;
						}


						if(cont == 2) {
							System.out.println("PASO");
							t.setCandidatsTauler(i, j, aux2);
							t.setCandidatsTauler(k, l, aux2);
						}
					}
				}

			}
		}
	}
}
