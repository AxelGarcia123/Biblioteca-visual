package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import modelo.Alumno;

import java.util.ArrayList;
import java.util.List;
import modelo.Estante;
import modelo.Grupo;
import modelo.Libro;
import modelo.TablaLibro;
import modelo.TablaPrestamo;
import modelo.BaseDatos;
import modelo.TablaAlumno;
import modelo.TablaDevolucion;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.awt.Font;
import java.awt.Color;
import java.awt.Frame;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuUsuarios;
	private MenuLateral menu;
	private DatosLibros panelCentralLibros;
	private DatosAlumno alumno;
	private Reportes reportes;
	private ReportesLibros reportesL;
	private ConsultaAlumno consultar;
	private ModificarAlumno modificar;
	private EliminarAlumno eliminar;
	private ConsultarLibro consultarLibro;
	private ModificarLibro modificarLibro;
	private EliminarLibro eliminarLibro;
	private VentanaPrestamo prestamo;
	private ReportePrestamos reportesP;
	private VentanaDevoluciones devoluciones;
	private ReportesDevoluciones reportesD;
	private TablaLibro tablaLibro;
	private TablaAlumno tablaAlumno;
	private TablaPrestamo tablaPrestamo;
	private TablaDevolucion tablaDevolucion;
	private BaseDatos baseDatos;
	private Footer footer;
	private JButton botonConsultar;
	private JButton botonModificar;
	private JButton botonRegistrarLibro;
	private JButton botonConsultarLibro;
	private JButton botonModificarLibro;
	private JButton botonEliminarLibro;
	private JButton botonOrdenarLibros;
	private JMenu gestionLibros;
	private JMenuItem actualizacionLibros;
	private JMenuItem reportesLibros;
	private JMenuItem graficasLibros;
	private Estante estante;
	private Grupo grupo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() throws FileNotFoundException {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/recursos/tree.png")));
		setTitle("Biblioteca Visual");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		estante = new Estante();
		grupo = new Grupo();

		baseDatos = new BaseDatos("biblioteca", "root", "17650010");
		baseDatos.setDriver("com.mysql.jdbc.Driver");
		baseDatos.setProtocolo("jdbc:mysql://localhost/");

		baseDatos.hacerConexion(); 
		tablaLibro = new TablaLibro(baseDatos.getConexion());
		tablaAlumno = new TablaAlumno(baseDatos.getConexion());
		tablaPrestamo = new TablaPrestamo(baseDatos.getConexion());
		tablaDevolucion = new TablaDevolucion(baseDatos.getConexion());

		menuUsuarios = new JMenuBar();
		menuUsuarios.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuUsuarios);

		JMenu gestionUsuarios = new JMenu("Gesti\u00F3n de Usuarios");
		gestionUsuarios.setBackground(new Color(0, 102, 102));
		gestionUsuarios.setForeground(new Color(0, 0, 0));
		gestionUsuarios.setFont(new Font("Dialog", Font.PLAIN, 20));
		gestionUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				contentPane.removeAll();
				menu = null;
				panelCentralLibros = null;
				consultarLibro = null;
				modificarLibro = null;
				eliminarLibro = null;
				alumno = null;
				reportes = null;
				consultar = null;
				modificar = null;
				eliminar = null;
				prestamo = null;
				contentPane.add(footer, BorderLayout.SOUTH);
				repaint();
			}
		});
		menuUsuarios.add(gestionUsuarios);

		JMenuItem opcionActualizaciones = new JMenuItem("Actualizaciones");
		opcionActualizaciones.setBackground(new Color(0, 206, 209));
		opcionActualizaciones.setForeground(Color.BLACK);
		opcionActualizaciones.setFont(new Font("Dialog", Font.PLAIN, 18));
		opcionActualizaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuLateral menu = new MenuLateral();
				registrarAlumno(menu);
				consultarAlumno(menu);
				modificarAlumno(menu);
				eliminarAlumno(menu);
				ordenarAlumnos(menu);
				contentPane.add(menu, BorderLayout.WEST);
				setVisible(true);
			}
		});
		gestionUsuarios.add(opcionActualizaciones);

		JMenuItem opcionReportes = new JMenuItem("Reportes");
		opcionReportes.setBackground(new Color(0, 206, 209));
		opcionReportes.setForeground(Color.BLACK);
		opcionReportes.setFont(new Font("Dialog", Font.PLAIN, 18));
		opcionReportes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reportes = new Reportes();
				contentPane.add(reportes, BorderLayout.CENTER);
				List<Alumno> alumnosBaseDatos = new ArrayList<>();
				alumnosBaseDatos = tablaAlumno.getAlumnos();
				reportes.mostrarConsulta(alumnosBaseDatos);
				setVisible(true);
			}
		});
		gestionUsuarios.add(opcionReportes);

		JMenuItem opcionGraficas = new JMenuItem("Gr\u00E1ficas");
		opcionGraficas.setBackground(new Color(0, 206, 209));
		opcionGraficas.setForeground(Color.BLACK);
		opcionGraficas.setFont(new Font("Dialog", Font.PLAIN, 18));
		gestionUsuarios.add(opcionGraficas);

		gestionLibros = new JMenu("Gesti\u00F3n de Libros");
		gestionLibros.setBackground(new Color(0, 102, 102));
		gestionLibros.setForeground(new Color(0, 0, 0));
		gestionLibros.setFont(new Font("Dialog", Font.PLAIN, 20));
		gestionLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				contentPane.removeAll();
				menu = null;
				panelCentralLibros = null;
				consultarLibro = null;
				modificarLibro = null;
				eliminarLibro = null;
				alumno = null;
				reportes = null;
				consultar = null;
				modificar = null;
				eliminar = null;
				prestamo = null;
				devoluciones = null;
				contentPane.add(footer, BorderLayout.SOUTH);
				repaint();
			}
		});
		menuUsuarios.add(gestionLibros);

		actualizacionLibros = new JMenuItem("Actualizaciones");
		actualizacionLibros.setForeground(new Color(0, 0, 0));
		actualizacionLibros.setBackground(new Color(0, 206, 209));
		actualizacionLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuLateral menu = new MenuLateral();
				registrarLibro(menu);
				consultarLibro(menu);
				modificarLibro(menu);
				eliminarLibro(menu);
				ordenarLibros(menu);
				contentPane.add(menu, BorderLayout.WEST);
				setVisible(true);
			}
		});
		actualizacionLibros.setFont(new Font("Dialog", Font.PLAIN, 18));
		gestionLibros.add(actualizacionLibros);

		reportesLibros = new JMenuItem("Reportes");
		reportesLibros.setForeground(new Color(0, 0, 0));
		reportesLibros.setBackground(new Color(0, 206, 209));
		reportesLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reportesL = new ReportesLibros();
				contentPane.add(reportesL, BorderLayout.CENTER);
				List<Libro> libroBaseDatos = new ArrayList<>();
				libroBaseDatos = tablaLibro.getLibros();
				reportesL.mostrarConsulta(libroBaseDatos);
				setVisible(true);
			}
		});
		reportesLibros.setFont(new Font("Dialog", Font.PLAIN, 18));
		gestionLibros.add(reportesLibros);

		graficasLibros = new JMenuItem("Gr\u00E1ficas");
		graficasLibros.setForeground(new Color(0, 0, 0));
		graficasLibros.setBackground(new Color(0, 206, 209));
		graficasLibros.setFont(new Font("Dialog", Font.PLAIN, 18));
		gestionLibros.add(graficasLibros);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		footer = new Footer();
		footer.setBackground(new Color(0, 112, 192));
		contentPane.add(footer, BorderLayout.SOUTH);

		JMenu gestionPrestamos = new JMenu("Gesti\u00f3n de pr\u00e9stamos.");
		gestionPrestamos.setBackground(new Color(0, 102, 102));
		gestionPrestamos.setForeground(new Color(0, 0, 0));
		gestionPrestamos.setFont(new Font("Dialog", Font.PLAIN, 20));
		gestionPrestamos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				contentPane.removeAll();
				menu = null;
				panelCentralLibros = null;
				consultarLibro = null;
				modificarLibro = null;
				eliminarLibro = null;
				alumno = null;
				reportes = null;
				consultar = null;
				modificar = null;
				eliminar = null;
				prestamo = null;
				devoluciones = null;
				contentPane.add(footer, BorderLayout.SOUTH);
				repaint();
			}
		});
		menuUsuarios.add(gestionPrestamos);

		JMenuItem solicitarLibro = new JMenuItem("Solicitar Libro");
		solicitarLibro.setBackground(new Color(0, 206, 209));
		solicitarLibro.setForeground(Color.BLACK);
		solicitarLibro.setFont(new Font("Dialog", Font.PLAIN, 18));
		solicitarLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				prestamo();
			}
		});
		gestionPrestamos.add(solicitarLibro);

		JMenuItem mostrarLibros = new JMenuItem("Reporte de libros prestados");
		mostrarLibros.setBackground(new Color(0, 206, 209));
		mostrarLibros.setForeground(Color.BLACK);
		mostrarLibros.setFont(new Font("Dialog", Font.PLAIN, 18));
		mostrarLibros.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reportesP = new ReportePrestamos();
				contentPane.add(reportesP, BorderLayout.CENTER);
				reportesP.mostrarConsulta(tablaPrestamo.getPrestamos());
				setVisible(true);
			}
		});
		gestionPrestamos.add(mostrarLibros);

		JMenu gestionDevoluciones = new JMenu("Gesti\u00f3n de Devoluciones.");
		gestionDevoluciones.setBackground(new Color(0, 102, 102));
		gestionDevoluciones.setForeground(new Color(0, 0, 0));
		gestionDevoluciones.setFont(new Font("Dialog", Font.PLAIN, 20));
		gestionDevoluciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				contentPane.removeAll();
				menu = null;
				panelCentralLibros = null;
				consultarLibro = null;
				modificarLibro = null;
				eliminarLibro = null;
				alumno = null;
				reportes = null;
				consultar = null;
				modificar = null;
				eliminar = null;
				prestamo = null;
				devoluciones = null;
				contentPane.add(footer, BorderLayout.SOUTH);
				repaint();
			}
		});
		menuUsuarios.add(gestionDevoluciones);

		JMenuItem devolverLibro = new JMenuItem("Devolver Libro");
		devolverLibro.setBackground(new Color(0, 206, 209));
		devolverLibro.setForeground(Color.BLACK);
		devolverLibro.setFont(new Font("Dialog", Font.PLAIN, 18));
		devolverLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				devolucion();
			}
		});
		gestionDevoluciones.add(devolverLibro);

		JMenuItem mostrarDevoluciones = new JMenuItem("Reporte de devolciones");
		mostrarDevoluciones.setBackground(new Color(0, 206, 209));
		mostrarDevoluciones.setForeground(Color.BLACK);
		mostrarDevoluciones.setFont(new Font("Dialog", Font.PLAIN, 18));
		mostrarDevoluciones.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reportesD = new ReportesDevoluciones();
				contentPane.add(reportesD, BorderLayout.CENTER);
				reportesD.mostrarConsulta(tablaDevolucion.getDevoluciones());
				setVisible(true);
			}
		});
		gestionDevoluciones.add(mostrarDevoluciones);
	}

	private void registrarLibro(MenuLateral menu) {
		botonRegistrarLibro = menu.getBotonRegistrar();
		botonRegistrarLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				consultarLibro = null;
				modificarLibro = null;
				eliminarLibro = null;
				alumno = null;
				reportes = null;
				consultar = null;
				modificar = null;
				eliminar = null;
				prestamo = null;
				devoluciones = null;
				if(panelCentralLibros == null) {
					panelCentralLibros = new DatosLibros();
					JTextField cajaIsbn = panelCentralLibros.getCajaIsbn();
					cajaIsbn.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(!cajaIsbn.getText().isEmpty() && cajaIsbn.getText().length() == 15) {
								if(!tablaLibro.existe(cajaIsbn.getText())) {
									panelCentralLibros.enfocarTitulo();
								}
								else {
									JOptionPane.showMessageDialog(null, "Este libro ya est\u00fa registrado.", null, JOptionPane.ERROR_MESSAGE);
									cajaIsbn.setText(null);
									cajaIsbn.requestFocus();
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio o tener menos de 15 d\u00edgitos.", null, JOptionPane.ERROR_MESSAGE);
								cajaIsbn.setText(null);
								cajaIsbn.requestFocus();
							}
						}
					});

					panelCentralLibros.getBotonGuardar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(!panelCentralLibros.hayCajasVacias()) {
								if (!tablaLibro.existe(cajaIsbn.getText())) {
									tablaLibro.guardar(panelCentralLibros.getLibro());
									JOptionPane.showMessageDialog(null, "Libro registrado.\n"+ estante.mostrarLibros());
									JOptionPane.showMessageDialog(null, "Libro registrado.\n"+ estante.mostrarLibros());
									panelCentralLibros.vaciarCajas();
								}

								else {
									JOptionPane.showMessageDialog(null, "Este libro ya est\u00e1 registrado.", null, JOptionPane.ERROR_MESSAGE);
									cajaIsbn.setText(null);
									cajaIsbn.requestFocus();
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Llene todos los campos vacios.", null, JOptionPane.ERROR_MESSAGE);
							}
						}
					});

					panelCentralLibros.getBotonCancelar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							contentPane.remove(panelCentralLibros);
							panelCentralLibros = null;
							repaint();
						}
					});
				}
				contentPane.add(panelCentralLibros, BorderLayout.CENTER);
				panelCentralLibros.fijarFoco();
				setVisible(true);
			}
		});
	}

	public void consultarLibro(MenuLateral menu) {
		botonConsultarLibro = menu.getBotonConsultar();
		botonConsultarLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelCentralLibros = null;
				modificarLibro = null;
				eliminarLibro = null;
				alumno = null;
				reportes = null;
				consultar = null;
				modificar = null;
				eliminar = null;
				prestamo = null;
				devoluciones = null;
				if(consultarLibro == null) {
					consultarLibro = new ConsultarLibro();
					consultarLibro.getBotonBuscar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(!consultarLibro.getCampo().getText().isEmpty() && consultarLibro.getCampo().getText().length() == 15) {
								if(tablaLibro.existe(consultarLibro.getCampo().getText())) {
									consultarLibro.mostrarDatosLibro(tablaLibro.getLibro(consultarLibro.getCampo().getText()));
								}
								else {
									JOptionPane.showMessageDialog(null, "No existe nin\u00fan libro con ese Isbn.", null, JOptionPane.ERROR_MESSAGE);
									consultarLibro.enfocarCursor();
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio o tener menos de 15 d\u00edgitos.", null, JOptionPane.ERROR_MESSAGE);
								consultarLibro.enfocarCursor();
							}
						}
					});

					consultarLibro.getBotonAceptar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							consultarLibro.limpiarCampos();
						}
					});

					consultarLibro.getBotonCancelar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							contentPane.remove(consultarLibro);
							consultarLibro = null;
							repaint();
						}
					});
				}
				contentPane.add(consultarLibro, BorderLayout.CENTER);						
				setVisible(true);
			}
		});
	}

	private void modificarLibro(MenuLateral menu) {
		botonModificarLibro = menu.getBotonModificar();
		botonModificarLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelCentralLibros = null;
				consultarLibro = null;
				eliminarLibro = null;
				alumno = null;
				reportes = null;
				consultar = null;
				modificar = null;
				eliminar = null;
				prestamo = null;
				devoluciones = null;
				if(modificarLibro == null) {
					modificarLibro = new ModificarLibro();
					modificarLibro.getBotonBuscarLibro().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(!tablaPrestamo.estaVacia()) {
								if(!tablaLibro.estaVacia()) {
									if(!modificarLibro.getCampoBuscar().isEmpty()) {
										if(modificarLibro.getCampoBuscar().length() == 15) {
											if(tablaLibro.existe(modificarLibro.getCampoBuscar())) {
												if(!tablaPrestamo.existeIsbn(modificarLibro.getCampoBuscar())) {
													modificarLibro.mostrarDatosLibro(tablaLibro.getLibro(modificarLibro.getCampoBuscar()));
												}
												else {
													JOptionPane.showMessageDialog(null, "Ese libro est\u00e1 prestado\nNo puede ser modificado.", null, JOptionPane.ERROR_MESSAGE);
													modificarLibro.enfocarCursor();
												}
											}
											else {
												JOptionPane.showMessageDialog(null, "No hay ning\u00fan libro registrado con ese ISBN.", null, JOptionPane.ERROR_MESSAGE);
												modificarLibro.enfocarCursor();
											}
										}
										else {
											JOptionPane.showMessageDialog(null, "El \"Isbn\" debe tener 15 d\u00edgitos.", null, JOptionPane.ERROR_MESSAGE);
											modificarLibro.enfocarCursor();
										}
									}
									else {
										JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
										modificarLibro.enfocarCursor();
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "No hay ning\u00fan libro registrado a\u00fan.", null, JOptionPane.ERROR_MESSAGE);
									modificarLibro.enfocarCursor();
								}
							}
							else {
								if(!estante.estaVacio()) {
									if(!modificarLibro.getCampoBuscar().isEmpty()) {
										if(modificarLibro.getCampoBuscar().length() == 15) {
											if(tablaLibro.existe(modificarLibro.getCampoBuscar())) {
												modificarLibro.mostrarDatosLibro(tablaLibro.getLibro(modificarLibro.getCampoBuscar()));
											}
											else {
												JOptionPane.showMessageDialog(null, "No hay ning\u00fan libro registrado con ese ISBN.", null, JOptionPane.ERROR_MESSAGE);
												modificarLibro.enfocarCursor();
											}
										}
										else {
											JOptionPane.showMessageDialog(null, "El \"Isbn\" debe tener 15 d\u00edgitos.", null, JOptionPane.ERROR_MESSAGE);
											modificarLibro.enfocarCursor();
										}
									}
									else {
										JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
										modificarLibro.enfocarCursor();
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "No hay ning\u00fan libro registrado a\u00fan.", null, JOptionPane.ERROR_MESSAGE);
									modificarLibro.enfocarCursor();
								}
							}
						}
					});

					modificarLibro.getBotonModificar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(!tablaLibro.estaVacia()) {
								if(!modificarLibro.getNoControl().isEmpty()) {
									if(!modificarLibro.hayCajasVacias()) {
										tablaLibro.modificar(modificarLibro.getLibro());
										modificarLibro.limpiarCampos();
										modificarLibro.enfocarCursor();
										JOptionPane.showMessageDialog(null, "El libro ha sido modificado.");
									}
									else
										JOptionPane.showMessageDialog(null, "Hay campos que no pueden quedar vacios.", null, JOptionPane.ERROR_MESSAGE);
								}
								else {
									JOptionPane.showMessageDialog(null, "Busque un libro primero.", null, JOptionPane.ERROR_MESSAGE);
									modificarLibro.enfocarCursor();
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "No hay ning\u00fan libro registrado a\u00fan.", null, JOptionPane.ERROR_MESSAGE);
								modificarLibro.enfocarCursor();
							}
						}
					});

					modificarLibro.getBotonCancelar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							contentPane.remove(modificarLibro);
							modificarLibro = null;
							repaint();
						}
					});
				}

				contentPane.add(modificarLibro, BorderLayout.CENTER);						
				setVisible(true);
			}
		});
	}

	private void eliminarLibro(MenuLateral menu) {
		botonEliminarLibro = menu.getBotonEliminar();
		botonEliminarLibro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelCentralLibros = null;
				consultarLibro = null;
				modificarLibro = null;
				alumno = null;
				reportes = null;
				consultar = null;
				modificar = null;
				eliminar = null;
				prestamo = null;
				devoluciones = null;
				if(eliminarLibro == null) {
					eliminarLibro = new EliminarLibro();
					eliminarLibro.getBotonBuscar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(!tablaLibro.estaVacia()) {
								if(!eliminarLibro.getCampo().getText().isEmpty() && eliminarLibro.getCampo().getText().length() == 15) {
									if(tablaLibro.existe(eliminarLibro.getCampo().getText())) {
										if(!tablaPrestamo.existeIsbn(eliminarLibro.getCampo().getText())) {
											eliminarLibro.mostrarDatosLibro(tablaLibro.getLibro(eliminarLibro.getCampo().getText()));
										}
										else {
											JOptionPane.showMessageDialog(null, "Ese libro est\u00e1 prestado.\nNo puede ser eliminado.", null, JOptionPane.ERROR_MESSAGE);
											eliminarLibro.enfocarCursor();
										}
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio o tener menos de 15 d\u00edgitos.", null, JOptionPane.ERROR_MESSAGE);
									eliminarLibro.enfocarCursor();
								}		
							}
							else {
								JOptionPane.showMessageDialog(null, "No hay ning\u00fan libro registrado a\u00fan.", null, JOptionPane.ERROR_MESSAGE);
								eliminarLibro.enfocarCursor();
							}
						}
					});

					eliminarLibro.getBotonEliminar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(!eliminarLibro.getIsbn().isEmpty()) {
								tablaLibro.eliminar(eliminarLibro.getIsbn());
								JOptionPane.showMessageDialog(null, "Libro eliminado.");
								eliminarLibro.limpiarCampos();
							}
							else {
								JOptionPane.showMessageDialog(null, "Primero busque un libro para eliminar.", null, JOptionPane.ERROR_MESSAGE);
								eliminarLibro.enfocarCursor();
							}
						}
					});

					eliminarLibro.getBotonCancelar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							contentPane.remove(eliminarLibro);
							eliminarLibro = null;
							repaint();
						}
					});
				}

				contentPane.add(eliminarLibro, BorderLayout.CENTER);						
				setVisible(true);
			}
		});
	}

	private void ordenarLibros(MenuLateral menu) {
		botonOrdenarLibros = menu.getBotonOrdenar();
		botonOrdenarLibros.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelCentralLibros = null;
				consultarLibro = null;
				modificarLibro = null;
				eliminarLibro = null;
				alumno = null;
				reportes = null;
				consultar = null;
				modificar = null;
				eliminar = null;
				prestamo = null;
				devoluciones = null;
				if(!estante.estaVacio()) {
					estante.ordenar();
					JOptionPane.showMessageDialog(null, "Libros ordenados.");
				}
				else
					JOptionPane.showMessageDialog(null, "No hay libros registrados a\u00fan.", null, JOptionPane.ERROR_MESSAGE);
			}
		});

	}

	private void registrarAlumno(MenuLateral menu) {
		menu.getBotonRegistrar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelCentralLibros = null;
				consultarLibro = null;
				modificarLibro = null;
				eliminarLibro = null;
				reportes = null;
				consultar = null;
				modificar = null;
				eliminar = null;
				prestamo = null;
				devoluciones = null;
				repaint();
				if(alumno == null) {
					try {
						alumno = new DatosAlumno();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}

					JTextField editNoControl = alumno.getEditNoControl();
					editNoControl.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(!editNoControl.getText().isEmpty() && editNoControl.getText().length() == 8) {
								if(!tablaAlumno.existe(editNoControl.getText())) {
									alumno.enforcarNombre();
								}
								else {
									JOptionPane.showMessageDialog(null, "Este alumno ya ha sido registrado.");
									editNoControl.setText(null);
									editNoControl.requestFocus();
								}
							}
						}
					});

					alumno.getBotonGuardar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(alumno.noControl()) 
								JOptionPane.showMessageDialog(null, "El campo \"No. Control\" está vacio o tiene menos de 8 d\u00edgitos.", null, JOptionPane.ERROR_MESSAGE);
							else if(alumno.hayCamposVacios())
								JOptionPane.showMessageDialog(null, "Hay campos vacios que no pueden quedar as\u00ed", null, JOptionPane.ERROR_MESSAGE);
							else if(tablaAlumno.existe(editNoControl.getText())) {
								JOptionPane.showMessageDialog(null, "Este alumno ya est\u00e1 registrado.", null, JOptionPane.ERROR_MESSAGE);
								editNoControl.requestFocus();
								editNoControl.setText(null);
							}
							else {
								tablaAlumno.guardar(alumno.registrarAlumno());
								JOptionPane.showMessageDialog(null, "Alumno registrado");
								alumno.limpiarCampos();
							}
						}
					});

					alumno.getBotonCancelar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							contentPane.remove(alumno);
							alumno = null;
							repaint();
						}
					});
				}
				contentPane.add(alumno, BorderLayout.CENTER);						
				setVisible(true);
			}
		});
	}

	private void consultarAlumno(MenuLateral menu) {
		botonConsultar = menu.getBotonConsultar();
		botonConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelCentralLibros = null;
				consultarLibro = null;
				modificarLibro = null;
				eliminarLibro = null;
				alumno = null;
				reportes = null;
				modificar = null;
				eliminar = null;
				prestamo = null;
				devoluciones = null;
				if(consultar == null) {
					consultar = new ConsultaAlumno();
					consultar.getBoton().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(!tablaAlumno.estaVacia()) {
								if(!consultar.getDato().isEmpty() && consultar.getDato().length() == 8) {
									if(tablaAlumno.existe(consultar.getDato())) {
										Alumno alumno = tablaAlumno.getAlumno(consultar.getDato());
										consultar.mostrarAlumno(alumno);
									}
									else
										JOptionPane.showMessageDialog(null, "No hay alumnos con ese n\u00famero de control.", null, JOptionPane.ERROR_MESSAGE);
								}
								else
									JOptionPane.showMessageDialog(null, "El campo \"N\u00famero de Control\" no debe quedar vacio o tener menos de 8 d\u00edgitos.", null, JOptionPane.ERROR_MESSAGE);
							}
							else
								JOptionPane.showMessageDialog(null, "No hay alumnos registrados.", null, JOptionPane.ERROR_MESSAGE);
						}
					});

					consultar.getBotonAceptar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							consultar.limpiar();
							consultar.enfocarCursor();
						}
					});

					consultar.getBotonSalir().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							contentPane.remove(consultar);
							consultar = null;
							repaint();
						}
					});
				}
				contentPane.add(consultar, BorderLayout.CENTER);						
				setVisible(true);
			}
		});
	}

	private void modificarAlumno(MenuLateral menu) {
		botonModificar = menu.getBotonModificar();
		botonModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelCentralLibros = null;
				consultarLibro = null;
				modificarLibro = null;
				eliminarLibro = null;
				alumno = null;
				reportes = null;
				consultar = null;
				eliminar = null;
				prestamo = null;
				devoluciones = null;
				if(modificar == null) {
					modificar = new ModificarAlumno();
					modificar.getBotonBuscar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(!tablaPrestamo.estaVacia()) {
								if((!modificar.campoVacio() && modificar.longitudCampo()) || modificar.campoBuscar() == null) {
									if(!tablaAlumno.estaVacia()) {
										if(tablaAlumno.existe(modificar.campoBuscar())) {
											if(!tablaPrestamo.existeNumeroControl(modificar.campoBuscar())) {
												modificar.mostrarDatos((tablaAlumno.getAlumno(modificar.campoBuscar())));
											}
											else {
												JOptionPane.showMessageDialog(null, "Este alumno tiene un libro prestado.\nNo puede ser modificado.", null, JOptionPane.ERROR_MESSAGE);
												modificar.enfocarCursor();
											}
										}
										else {
											JOptionPane.showMessageDialog(null, "No existe alumnos con ese n\u00famero de control.", null, JOptionPane.ERROR_MESSAGE);
											modificar.enfocarCursor();
										}		
									}
									else {
										JOptionPane.showMessageDialog(null, "No hay ning\u00fan alumno registrado a\u00fan.", null, JOptionPane.ERROR_MESSAGE);
										modificar.enfocarCursor();
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio o tener menos de 8 d\u00edgitos.", null, JOptionPane.ERROR_MESSAGE);
									modificar.enfocarCursor();
								}
							}
							else {
								if((!modificar.campoVacio() && modificar.longitudCampo()) || modificar.campoBuscar() == null) {
									if(!tablaAlumno.estaVacia()) {
										if(tablaAlumno.existe(modificar.campoBuscar())) {
											modificar.mostrarDatos((tablaAlumno.getAlumno(modificar.campoBuscar())));
										}
										else {
											JOptionPane.showMessageDialog(null, "No existe alumnos con ese n\u00famero de control.", null, JOptionPane.ERROR_MESSAGE);
											modificar.enfocarCursor();
										}		
									}
									else {
										JOptionPane.showMessageDialog(null, "No hay ning\u00fan alumno registrado a\u00fan.", null, JOptionPane.ERROR_MESSAGE);
										modificar.enfocarCursor();
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio o tener menos de 8 d\u00edgitos.", null, JOptionPane.ERROR_MESSAGE);
									modificar.enfocarCursor();
								}
							}
						}
					});

					modificar.getBotonModificar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(!modificar.getNoControl().isEmpty()) {
								if(!modificar.hayCamposVacios()) {
									tablaAlumno.eliminar(modificar.getNoControl());
									tablaAlumno.guardar(modificar.modificarAlumno());
									JOptionPane.showMessageDialog(null, "El alumno ha sido modificado.");
									modificar.limpiarCampos();
								}
								else
									JOptionPane.showMessageDialog(null, "Hay campos vacios que no pueden quedar as\u00ed", null, JOptionPane.ERROR_MESSAGE);
							}
							else {
								JOptionPane.showMessageDialog(null, "Busque a un alumno primero.", null, JOptionPane.ERROR_MESSAGE);
								modificar.enfocarCursor();
							}
						}
					});

					modificar.getBotonCancelar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							contentPane.remove(modificar);
							modificar = null;
							repaint();
						}
					});
				}
				contentPane.add(modificar, BorderLayout.CENTER);						
				setVisible(true);
			}
		});
	}

	private void eliminarAlumno(MenuLateral menu) {
		menu.getBotonEliminar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelCentralLibros = null;
				consultarLibro = null;
				modificarLibro = null;
				eliminarLibro = null;
				alumno = null;
				reportes = null;
				consultar = null;
				modificar = null;
				prestamo = null;
				devoluciones = null;
				if(eliminar == null) {
					eliminar = new EliminarAlumno();
					eliminar.getBoton().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(!tablaAlumno.estaVacia()) {
								if(!eliminar.getDato().isEmpty() && eliminar.getDato().length() == 8) {
									if(tablaAlumno.existe(eliminar.getDato())) {
										if(!tablaPrestamo.existeNumeroControl(eliminar.getDato())) {
											Alumno alumno = tablaAlumno.getAlumno(eliminar.getDato());
											eliminar.mostrarAlumno(alumno);
										}
										else
											JOptionPane.showMessageDialog(null, "Este alumno tiene un libro prestado.\nNo puede ser eliminado.", null, JOptionPane.ERROR_MESSAGE);
									}
									else
										JOptionPane.showMessageDialog(null, "No hay alumnos con ese n\u00famero de control.", null, JOptionPane.ERROR_MESSAGE);
								}
								else
									JOptionPane.showMessageDialog(null, "El campo \"N\u00famero de Control\" no debe quedar vacio o tener menos de 8 d\u00edgitos.", null, JOptionPane.ERROR_MESSAGE);
							}
							else
								JOptionPane.showMessageDialog(null, "No hay alumnos registrados.", null, JOptionPane.ERROR_MESSAGE);
						}
					});

					eliminar.getBotonEliminar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(!tablaAlumno.estaVacia()) {
								if(!eliminar.noControlVacio()) {
									tablaAlumno.eliminar(eliminar.getNoControl());
									JOptionPane.showMessageDialog(null, "Alumno eliminado.");
									eliminar.limpiar();
									eliminar.enfocarCursor();
								}
								else
									JOptionPane.showMessageDialog(null, "Busque primero a un Alumno.", null, JOptionPane.ERROR_MESSAGE);
							}
							else
								JOptionPane.showMessageDialog(null, "No hay nin\u00famero alumno registrado.", null, JOptionPane.ERROR_MESSAGE);
						}
					});

					eliminar.getBotonCancelar().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							contentPane.remove(eliminar);
							eliminar = null;
							repaint();
						}
					});
				}
				contentPane.add(eliminar, BorderLayout.CENTER);						
				setVisible(true);
			}
		});
	}

	private void ordenarAlumnos(MenuLateral menu) {
		botonModificar = menu.getBotonOrdenar();
		botonModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelCentralLibros = null;
				consultarLibro = null;
				modificarLibro = null;
				eliminarLibro = null;
				alumno = null;
				reportes = null;
				consultar = null;
				modificar = null;
				eliminar = null;
				prestamo = null;
				devoluciones = null;
				if(!grupo.estaVacio()) {
					grupo.ordenar();
					JOptionPane.showMessageDialog(null, "Alumnos ordenados.");
				}
				else
					JOptionPane.showMessageDialog(null, "No hay alumnos registrados a\u00fan.", null, JOptionPane.ERROR_MESSAGE);
			}
		});
	}

	private void prestamo() {
		if(prestamo == null) {
			prestamo = new VentanaPrestamo();
			prestamo.getBotonBuscar().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(!tablaAlumno.estaVacia()) {
						if(!tablaLibro.estaVacia()) {
							if(!prestamo.getEditBuscar().getText().isEmpty()) {
								if(tablaAlumno.existe(prestamo.getEditBuscar().getText())) {
									prestamo.mostrarDatos(tablaLibro.getLibros(), tablaPrestamo);
									if(prestamo.getComboBox().getItemCount() == 0) {
										JOptionPane.showMessageDialog(null, "No hay libros disponibles para prestar.", null, JOptionPane.ERROR_MESSAGE);
										prestamo.enfocarCursor();
										prestamo.limpiar();
									}
									else {
										
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "No hay alumno registrado con ese n\u00famero de control.", null, JOptionPane.ERROR_MESSAGE);
									prestamo.enfocarCursor();
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
								prestamo.enfocarCursor();
							}
						}
						else
							JOptionPane.showMessageDialog(null, "No hay n\u00fan libro registrado.", null, JOptionPane.ERROR_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(null, "No hay ning\u00fan alumno registrado.", null, JOptionPane.ERROR_MESSAGE);
				}
			});

			prestamo.getComboBox().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String isbn = prestamo.getComboBox().getSelectedItem().toString();
					if(tablaLibro.existe(isbn)) {
						prestamo.getTituloLabel().setText(tablaLibro.getLibro(isbn).getTitle());
					}
				}
			});;

			prestamo.getBotonGuardar().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(!prestamo.getEditBuscar().getText().isEmpty() || prestamo.getEditBuscar().getText() != null) {
						if(!prestamo.getTituloLabel().getText().isEmpty() && prestamo.getTituloLabel().getText() != null) {
							tablaPrestamo.guardar(prestamo.registrarPrestamo());
							JOptionPane.showMessageDialog(null, "Pr\u00e9stamo registrado.");
							prestamo.limpiar();
						}
						else {
							JOptionPane.showMessageDialog(null, "Seleccione un libro primero.", null, JOptionPane.ERROR_MESSAGE);
							prestamo.enfocarCursor();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Busque el n\u00famero de control.", null, JOptionPane.ERROR_MESSAGE);
						prestamo.enfocarCursor();
					}
				}
			});

			prestamo.getBotonCancelar().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					contentPane.remove(prestamo);
					prestamo = null;
					repaint();
				}
			});
			contentPane.add(prestamo, BorderLayout.CENTER);
			setVisible(true);
		}
	}

	private void devolucion() {
		if(devoluciones == null) {
			devoluciones = new VentanaDevoluciones();

			devoluciones.getBotonBuscar().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(!devoluciones.getCampoBuscar().getText().isEmpty()) {
						if(tablaPrestamo.existeIsbn(devoluciones.getCampoBuscar().getText())) {
							devoluciones.mostrarDatos(tablaPrestamo.getPrestamo(devoluciones.getCampoBuscar().getText()));
						}
						else {
							JOptionPane.showMessageDialog(null, "No hay libros prestados con ese Isbn.", null, JOptionPane.ERROR_MESSAGE);
							devoluciones.enfocarFoco();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio.", null, JOptionPane.ERROR_MESSAGE);
						devoluciones.enfocarFoco();
					}
				}
			});

			devoluciones.getBotonDevolver().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(!tablaPrestamo.estaVacia()) {
						if(!devoluciones.getDatoIsbn().isEmpty() && devoluciones.getDatoIsbn() != null) {
							tablaPrestamo.eliminar(devoluciones.getDatoIsbn());
							tablaDevolucion.guardar(devoluciones.devolverLibro());
							JOptionPane.showMessageDialog(null, "El libro ha sido devuelto.");
							devoluciones.limpiarCampos();
						}
						else {
							JOptionPane.showMessageDialog(null, "Busque primero el Isbn.", null, JOptionPane.ERROR_MESSAGE);
							devoluciones.enfocarFoco();
						}
					}
					else
						JOptionPane.showMessageDialog(null, "No hay ning\u00fan pr\u00e9stamo realizado.", null, JOptionPane.ERROR_MESSAGE);
				}
			});

			devoluciones.getBotonCancelar().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					contentPane.remove(devoluciones);
					devoluciones = null;
					repaint();
				}
			});

			contentPane.add(devoluciones, BorderLayout.CENTER);
			setVisible(true);
		}
	}
}