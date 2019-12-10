package modelo;

public class Alumno implements Comparable<Alumno>{
	private String controlNumber;
	private String name;
	private String paternal;
	private String maternal;
	private String sex;
	private String fechaNacimiento;
	private Domicilio address;
	private String telefono;
	private String email;
	private String carrera;
	private String semestre;
	
	public Alumno() {
		
	}
	
	public Alumno(String controlNumber, String name, String paternal, String maternal, String sex,
			String fechaNacimiento, String telefono, String email, String carrera, String semestre, Domicilio address) {
		super();
		this.controlNumber = controlNumber;
		this.name = name;
		this.paternal = paternal;
		this.maternal = maternal;
		this.sex = sex;
		this.fechaNacimiento = fechaNacimiento;
		this.address = address;
		this.telefono = telefono;
		this.email = email;
		this.carrera = carrera;
		this.semestre = semestre;
	}

	public Alumno(String controlNumber) {
		this.controlNumber = controlNumber;
	}
	
	public String getControlNumber() {
		return controlNumber;
	}
	public void setControlNumber(String controlNumber) {
		this.controlNumber = controlNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPaternal() {
		return paternal;
	}
	public void setPaternal(String paternal) {
		this.paternal = paternal;
	}
	public String getMaternal() {
		return maternal;
	}
	public void setMaternal(String maternal) {
		this.maternal = maternal;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Domicilio getAddress() {
		return address;
	}
	public void setAddress(Domicilio address) {
		this.address = address;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	@Override
	public String toString() {
		String salida = "";
		salida += "N\u00famero de Control: "+ controlNumber + "\n";
		salida += "Nombre: "+ name + "\n";
		salida += "Apellido Paterno: "+ paternal + "\n";
		salida += "Apellido Materno: "+ maternal + "\n";
		salida += "Sexo: "+ sex + "\n";
		salida += "Fecha de Nacimiento: "+ fechaNacimiento + "\n";
		salida += "Direcci\u00f3n: "+ address + "\n";
		salida += "Tel\u00e9fono: " + telefono + "\n";
		salida += "E-Mail: " + email + "\n";
		salida += "Carrera: " + carrera + "\n";
		salida += "Semestre: " + semestre;
		return salida;
	}
	
	@Override
	public boolean equals(Object o) {
		Alumno alumno = (Alumno) o;
		return controlNumber.equals(alumno.getControlNumber());
	}

	@Override
	public int compareTo(Alumno alumno) {
		return controlNumber.compareTo(alumno.controlNumber);
	}
}