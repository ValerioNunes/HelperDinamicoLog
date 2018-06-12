package Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Evento implements java.io.Serializable {
	
	Date time;
	String PONTO_DE_ACELERAÇÃO,INDICAÇÃO_MAQUINISTA;
	int POSIÇÃOHELPER_GPS;
	int VELOCREALGPSHELPER;
	double DIST_RELAT_LE,DIST_RELAT_LD, VEL_RELAT_LE, VEL_RELAT_LD;
	int PRESSAOFREIO,PRESSAO_CILINDRO_PRINCIPAL;
	int BAT_EOT,ID_EOT,PRESSÃO_EG_EOT,VELOC_REAL_GPS_EOT;
	int CILINDRO_RETORNO_E ,CILINDRO_AVANCO_E,CILINDRO_TELEMETRO,CHAVE_INTERLOCK,TECLA_TELA,TECLA_BZRESET,TECLA_LIP_PINO_ENGATE,TECLA_OP_ALINHAR;   
	int E,D,C,B,A,CILINDRO_PINO_ENGATE,CILINDRO_RETORNO_D,CILINDRO_AVANCO_D;
	int CORTE_TRACAO,EMERGENCIA,SIRENE,VALVULA_TELEMETRO,VALVULA_RETORNO_ALINHAMENTO,VALVULA_AVANÇO_ALINHAMENTO,VALVULA_PINO_ENGATE;
	int VELOC_RELATIVA_GPS_EOT_HELPER,DIST_RELATIVA_GPS_EOT_HELPER,POSIÇÃO_EOT_GPS,ESTADO_GPS_EOT,CONT_GPS_EOT_VIVO,ESTADO_GPS_HELPER,CONT_GPS_HELPER_VIVO;
	int ESTADO_LASER_END2,CON_LASER_END2,ESTADO_LASER_END3,CONT_LASER_END3,TEMP_LASER_END2, TEMP_LASER_END3;
	String ALARME1,ALARME2,ALARME3,LOCALIZACAO_OK_HELPER;
	
	public Evento(String ev){
		try {
		Time(ev);
		
		GPSHELPER(ev);
		DIST_VEL_RELAT_Laser(ev);
		EOT(ev);
		Binario(ev);
		INDICAÇÃO_MAQUINISTA(ev);
		Alarmes(ev);
		Pressao(ev);
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Arquivo TXT corrompido !!!");
			
		}
		

	}

	void Time(String ev){
		try {		
			DateFormat formatter = new SimpleDateFormat("ddMMyyHHmmss");
			time = (Date)formatter.parse(ev.substring(1,13));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//JOptionPane.showMessageDialog(null, "Arquivo TXT corrompido na Data e Hora!!!");
			System.out.print(e.getMessage());
		}
	}
	
	void GPSHELPER(String ev){
		POSIÇÃOHELPER_GPS =  Integer.valueOf(ev.substring(13,19).replace("+",""));
		VELOCREALGPSHELPER =  Integer.valueOf(ev.substring(19,21));
	    VELOC_RELATIVA_GPS_EOT_HELPER = Integer.valueOf(ev.substring(73,75));
		DIST_RELATIVA_GPS_EOT_HELPER =  Integer.valueOf(ev.substring(76,80));
		ESTADO_GPS_HELPER =  Integer.valueOf(ev.substring(95,96));
		CONT_GPS_HELPER_VIVO=  Integer.valueOf(ev.substring(96,99));
	}
	
	void DIST_VEL_RELAT_Laser(String ev){
		 DIST_RELAT_LE = Double.valueOf(ev.substring(21,24))/10.0;
		 VEL_RELAT_LE = Double.valueOf(ev.substring(25,27));
		 
		 DIST_RELAT_LD = Double.valueOf(ev.substring(27,30))/10.0;
		 VEL_RELAT_LD = Double.valueOf(ev.substring(31,33));
		 
		 ESTADO_LASER_END2 =  Integer.valueOf(ev.substring(99,100));
		 CON_LASER_END2    =  Integer.valueOf(ev.substring(100,103));
		 ESTADO_LASER_END3 =  Integer.valueOf(ev.substring(103,104));
		 CONT_LASER_END3   =  Integer.valueOf(ev.substring(104,107));
		 
		 TEMP_LASER_END2  =  Integer.valueOf(ev.substring(116,118));
		 TEMP_LASER_END3  =  Integer.valueOf(ev.substring(118,120));
	}
	
	void Pressao(String ev){
		
		this.PRESSAOFREIO =  Integer.valueOf(ev.substring(33,36));
		this.PRESSAO_CILINDRO_PRINCIPAL =  Integer.valueOf(ev.substring(36,39));
	
	}
	
	void EOT(String ev){
		BAT_EOT  = Integer.valueOf(ev.substring(39,42));
		ID_EOT  = Integer.valueOf(ev.substring(42,44));
		PRESSÃO_EG_EOT = Integer.valueOf(ev.substring(44,46));
		VELOC_REAL_GPS_EOT = Integer.valueOf(ev.substring(46,48));
		POSIÇÃO_EOT_GPS = Integer.valueOf(ev.substring(81,86));
		ESTADO_GPS_EOT = Integer.valueOf(ev.substring(91,92));
		CONT_GPS_EOT_VIVO = Integer.valueOf(ev.substring(92,95));
	}
	
	void Binario(String ev){
		
		CILINDRO_RETORNO_E = Integer.valueOf(ev.substring(48,49));
		CILINDRO_AVANCO_E  = Integer.valueOf(ev.substring(49,50));
		CILINDRO_TELEMETRO = Integer.valueOf(ev.substring(50,51));
		CHAVE_INTERLOCK    = Integer.valueOf(ev.substring(51,52));
		TECLA_TELA         = Integer.valueOf(ev.substring(52,53));
		TECLA_BZRESET      = Integer.valueOf(ev.substring(53,54));
		TECLA_LIP_PINO_ENGATE = Integer.valueOf(ev.substring(54,55));
		TECLA_OP_ALINHAR  = Integer.valueOf(ev.substring(55,56));
		
		E				  = Integer.valueOf(ev.substring(56,57));	
		D				  = Integer.valueOf(ev.substring(57,58));
		C				  = Integer.valueOf(ev.substring(58,59));						
		B				  = Integer.valueOf(ev.substring(59,60));
		A				  = Integer.valueOf(ev.substring(60,61));
		CILINDRO_PINO_ENGATE= Integer.valueOf(ev.substring(61,62));
		CILINDRO_RETORNO_D= Integer.valueOf(ev.substring(62,63));
		CILINDRO_AVANCO_D = Integer.valueOf(ev.substring(63,64));
		PONTO_DE_ACELERAÇÃO=                ev.substring(64,65);
		CORTE_TRACAO      = Integer.valueOf(ev.substring(65,66));
		EMERGENCIA        = Integer.valueOf(ev.substring(66,67));
		SIRENE            = Integer.valueOf(ev.substring(67,68));
		VALVULA_TELEMETRO = Integer.valueOf(ev.substring(68,69));
		VALVULA_RETORNO_ALINHAMENTO = Integer.valueOf(ev.substring(69,70));
		VALVULA_AVANÇO_ALINHAMENTO = Integer.valueOf(ev.substring(70,71));
		VALVULA_PINO_ENGATE = Integer.valueOf(ev.substring(71,72));
		
	}
	void INDICAÇÃO_MAQUINISTA(String ev){
		INDICAÇÃO_MAQUINISTA = ev.substring(86,91);
	}
	
	
	void Alarmes(String ev){
		ALARME1 = ev.substring(107, 110);
		ALARME2	= ev.substring(110, 113);
		ALARME3	= ev.substring(113, 116);
		LOCALIZACAO_OK_HELPER = ev.substring(116, 157);
	}
	
	
	public String getPONTO_DE_ACELERAÇÃO() {
		return PONTO_DE_ACELERAÇÃO;
	}

	public void setPONTO_DE_ACELERAÇÃO(String pONTO_DE_ACELERAÇÃO) {
		PONTO_DE_ACELERAÇÃO = pONTO_DE_ACELERAÇÃO;
	}

	public String getINDICAÇÃO_MAQUINISTA() {
		return INDICAÇÃO_MAQUINISTA;
	}

	public void setINDICAÇÃO_MAQUINISTA(String iNDICAÇÃO_MAQUINISTA) {
		INDICAÇÃO_MAQUINISTA = iNDICAÇÃO_MAQUINISTA;
	}

	public double getDIST_RELAT_LD() {
		return DIST_RELAT_LD;
	}

	public void setDIST_RELAT_LD(double dIST_RELAT_LD) {
		DIST_RELAT_LD = dIST_RELAT_LD;
	}

	public double getVEL_RELAT_LE() {
		return VEL_RELAT_LE;
	}

	public void setVEL_RELAT_LE(double vEL_RELAT_LE) {
		VEL_RELAT_LE = vEL_RELAT_LE;
	}

	public double getVEL_RELAT_LD() {
		return VEL_RELAT_LD;
	}

	public void setVEL_RELAT_LD(double vEL_RELAT_LD) {
		VEL_RELAT_LD = vEL_RELAT_LD;
	}

	public int getPRESSAOFREIO() {
		return PRESSAOFREIO;
	}

	public void setPRESSAOFREIO(int pRESSAOFREIO) {
		PRESSAOFREIO = pRESSAOFREIO;
	}

	public int getPRESSAO_CILINDRO_PRINCIPAL() {
		return PRESSAO_CILINDRO_PRINCIPAL;
	}

	public void setPRESSAO_CILINDRO_PRINCIPAL(int pRESSAO_CILINDRO_PRINCIPAL) {
		PRESSAO_CILINDRO_PRINCIPAL = pRESSAO_CILINDRO_PRINCIPAL;
	}

	public int getBAT_EOT() {
		return BAT_EOT;
	}

	public void setBAT_EOT(int bAT_EOT) {
		BAT_EOT = bAT_EOT;
	}

	public int getID_EOT() {
		return ID_EOT;
	}

	public void setID_EOT(int iD_EOT) {
		ID_EOT = iD_EOT;
	}

	public int getPRESSÃO_EG_EOT() {
		return PRESSÃO_EG_EOT;
	}

	public void setPRESSÃO_EG_EOT(int pRESSÃO_EG_EOT) {
		PRESSÃO_EG_EOT = pRESSÃO_EG_EOT;
	}

	public int getVELOC_REAL_GPS_EOT() {
		return VELOC_REAL_GPS_EOT;
	}

	public void setVELOC_REAL_GPS_EOT(int vELOC_REAL_GPS_EOT) {
		VELOC_REAL_GPS_EOT = vELOC_REAL_GPS_EOT;
	}

	public int getCILINDRO_RETORNO_E() {
		return CILINDRO_RETORNO_E;
	}

	public void setCILINDRO_RETORNO_E(int cILINDRO_RETORNO_E) {
		CILINDRO_RETORNO_E = cILINDRO_RETORNO_E;
	}

	public int getCILINDRO_AVANCO_E() {
		return CILINDRO_AVANCO_E;
	}

	public void setCILINDRO_AVANCO_E(int cILINDRO_AVANCO_E) {
		CILINDRO_AVANCO_E = cILINDRO_AVANCO_E;
	}

	public int getCILINDRO_TELEMETRO() {
		return CILINDRO_TELEMETRO;
	}

	public void setCILINDRO_TELEMETRO(int cILINDRO_TELEMETRO) {
		CILINDRO_TELEMETRO = cILINDRO_TELEMETRO;
	}

	public int getCHAVE_INTERLOCK() {
		return CHAVE_INTERLOCK;
	}

	public void setCHAVE_INTERLOCK(int cHAVE_INTERLOCK) {
		CHAVE_INTERLOCK = cHAVE_INTERLOCK;
	}

	public int getTECLA_TELA() {
		return TECLA_TELA;
	}

	public void setTECLA_TELA(int tECLA_TELA) {
		TECLA_TELA = tECLA_TELA;
	}

	public int getTECLA_BZRESET() {
		return TECLA_BZRESET;
	}

	public void setTECLA_BZRESET(int tECLA_BZRESET) {
		TECLA_BZRESET = tECLA_BZRESET;
	}

	public int getTECLA_LIP_PINO_ENGATE() {
		return TECLA_LIP_PINO_ENGATE;
	}

	public void setTECLA_LIP_PINO_ENGATE(int tECLA_LIP_PINO_ENGATE) {
		TECLA_LIP_PINO_ENGATE = tECLA_LIP_PINO_ENGATE;
	}

	public int getTECLA_OP_ALINHAR() {
		return TECLA_OP_ALINHAR;
	}

	public void setTECLA_OP_ALINHAR(int tECLA_OP_ALINHAR) {
		TECLA_OP_ALINHAR = tECLA_OP_ALINHAR;
	}

	public int getE() {
		return E;
	}

	public void setE(int e) {
		E = e;
	}

	public int getD() {
		return D;
	}

	public void setD(int d) {
		D = d;
	}

	public int getC() {
		return C;
	}

	public void setC(int c) {
		C = c;
	}

	public int getB() {
		return B;
	}

	public void setB(int b) {
		B = b;
	}

	public int getA() {
		return A;
	}

	public void setA(int a) {
		A = a;
	}

	public int getCILINDRO_PINO_ENGATE() {
		return CILINDRO_PINO_ENGATE;
	}

	public void setCILINDRO_PINO_ENGATE(int cILINDRO_PINO_ENGATE) {
		CILINDRO_PINO_ENGATE = cILINDRO_PINO_ENGATE;
	}

	public int getCILINDRO_RETORNO_D() {
		return CILINDRO_RETORNO_D;
	}

	public void setCILINDRO_RETORNO_D(int cILINDRO_RETORNO_D) {
		CILINDRO_RETORNO_D = cILINDRO_RETORNO_D;
	}

	public int getCILINDRO_AVANCO_D() {
		return CILINDRO_AVANCO_D;
	}

	public void setCILINDRO_AVANCO_D(int cILINDRO_AVANCO_D) {
		CILINDRO_AVANCO_D = cILINDRO_AVANCO_D;
	}

	public int getCORTE_TRACAO() {
		return CORTE_TRACAO;
	}

	public void setCORTE_TRACAO(int cORTE_TRACAO) {
		CORTE_TRACAO = cORTE_TRACAO;
	}

	public int getEMERGENCIA() {
		return EMERGENCIA;
	}

	public void setEMERGENCIA(int eMERGENCIA) {
		EMERGENCIA = eMERGENCIA;
	}

	public int getSIRENE() {
		return SIRENE;
	}

	public void setSIRENE(int sIRENE) {
		SIRENE = sIRENE;
	}

	public int getVALVULA_TELEMETRO() {
		return VALVULA_TELEMETRO;
	}

	public void setVALVULA_TELEMETRO(int vALVULA_TELEMETRO) {
		VALVULA_TELEMETRO = vALVULA_TELEMETRO;
	}

	public int getVALVULA_RETORNO_ALINHAMENTO() {
		return VALVULA_RETORNO_ALINHAMENTO;
	}

	public void setVALVULA_RETORNO_ALINHAMENTO(int vALVULA_RETORNO_ALINHAMENTO) {
		VALVULA_RETORNO_ALINHAMENTO = vALVULA_RETORNO_ALINHAMENTO;
	}

	public int getVALVULA_AVANÇO_ALINHAMENTO() {
		return VALVULA_AVANÇO_ALINHAMENTO;
	}

	public void setVALVULA_AVANÇO_ALINHAMENTO(int vALVULA_AVANÇO_ALINHAMENTO) {
		VALVULA_AVANÇO_ALINHAMENTO = vALVULA_AVANÇO_ALINHAMENTO;
	}

	public int getVALVULA_PINO_ENGATE() {
		return VALVULA_PINO_ENGATE;
	}

	public void setVALVULA_PINO_ENGATE(int vALVULA_PINO_ENGATE) {
		VALVULA_PINO_ENGATE = vALVULA_PINO_ENGATE;
	}

	public int getVELOC_RELATIVA_GPS_EOT_HELPER() {
		return VELOC_RELATIVA_GPS_EOT_HELPER;
	}

	public void setVELOC_RELATIVA_GPS_EOT_HELPER(int vELOC_RELATIVA_GPS_EOT_HELPER) {
		VELOC_RELATIVA_GPS_EOT_HELPER = vELOC_RELATIVA_GPS_EOT_HELPER;
	}

	public int getDIST_RELATIVA_GPS_EOT_HELPER() {
		return DIST_RELATIVA_GPS_EOT_HELPER;
	}

	public void setDIST_RELATIVA_GPS_EOT_HELPER(int dIST_RELATIVA_GPS_EOT_HELPER) {
		DIST_RELATIVA_GPS_EOT_HELPER = dIST_RELATIVA_GPS_EOT_HELPER;
	}

	public int getPOSIÇÃO_EOT_GPS() {
		return POSIÇÃO_EOT_GPS;
	}

	public void setPOSIÇÃO_EOT_GPS(int pOSIÇÃO_EOT_GPS) {
		POSIÇÃO_EOT_GPS = pOSIÇÃO_EOT_GPS;
	}

	public int getESTADO_GPS_EOT() {
		return ESTADO_GPS_EOT;
	}

	public void setESTADO_GPS_EOT(int eSTADO_GPS_EOT) {
		ESTADO_GPS_EOT = eSTADO_GPS_EOT;
	}

	public int getCONT_GPS_EOT_VIVO() {
		return CONT_GPS_EOT_VIVO;
	}

	public void setCONT_GPS_EOT_VIVO(int cONT_GPS_EOT_VIVO) {
		CONT_GPS_EOT_VIVO = cONT_GPS_EOT_VIVO;
	}

	public int getESTADO_GPS_HELPER() {
		return ESTADO_GPS_HELPER;
	}

	public void setESTADO_GPS_HELPER(int eSTADO_GPS_HELPER) {
		ESTADO_GPS_HELPER = eSTADO_GPS_HELPER;
	}

	public int getCONT_GPS_HELPER_VIVO() {
		return CONT_GPS_HELPER_VIVO;
	}

	public void setCONT_GPS_HELPER_VIVO(int cONT_GPS_HELPER_VIVO) {
		CONT_GPS_HELPER_VIVO = cONT_GPS_HELPER_VIVO;
	}

	public int getESTADO_LASER_END2() {
		return ESTADO_LASER_END2;
	}

	public void setESTADO_LASER_END2(int eSTADO_LASER_END2) {
		ESTADO_LASER_END2 = eSTADO_LASER_END2;
	}

	public int getCON_LASER_END2() {
		return CON_LASER_END2;
	}

	public void setCON_LASER_END2(int cON_LASER_END2) {
		CON_LASER_END2 = cON_LASER_END2;
	}

	public int getESTADO_LASER_END3() {
		return ESTADO_LASER_END3;
	}

	public void setESTADO_LASER_END3(int eSTADO_LASER_END3) {
		ESTADO_LASER_END3 = eSTADO_LASER_END3;
	}

	public int getCONT_LASER_END3() {
		return CONT_LASER_END3;
	}

	public void setCONT_LASER_END3(int cONT_LASER_END3) {
		CONT_LASER_END3 = cONT_LASER_END3;
	}

	public int getTEMP_LASER_END2() {
		return TEMP_LASER_END2;
	}

	public void setTEMP_LASER_END2(int tEMP_LASER_END2) {
		TEMP_LASER_END2 = tEMP_LASER_END2;
	}

	public int getTEMP_LASER_END3() {
		return TEMP_LASER_END3;
	}

	public void setTEMP_LASER_END3(int tEMP_LASER_END3) {
		TEMP_LASER_END3 = tEMP_LASER_END3;
	}

	public String getALARME1() {
		return ALARME1;
	}

	public void setALARME1(String aLARME1) {
		ALARME1 = aLARME1;
	}

	public String getALARME2() {
		return ALARME2;
	}

	public void setALARME2(String aLARME2) {
		ALARME2 = aLARME2;
	}

	public String getALARME3() {
		return ALARME3;
	}

	public void setALARME3(String aLARME3) {
		ALARME3 = aLARME3;
	}

	public String getLOCALIZACAO_OK_HELPER() {
		return LOCALIZACAO_OK_HELPER;
	}

	public void setLOCALIZACAO_OK_HELPER(String lOCALIZACAO_OK_HELPER) {
		LOCALIZACAO_OK_HELPER = lOCALIZACAO_OK_HELPER;
	}

	public double getDIST_RELAT_LE() {
		return DIST_RELAT_LE;
	}

	public void setDIST_RELAT_LE(int dIST_RELAT_LE) {
		DIST_RELAT_LE = dIST_RELAT_LE;
	}

	public void setDIST_RELAT_LE(double dIST_RELAT_LE) {
		DIST_RELAT_LE = dIST_RELAT_LE;
	}

	public int getVELOCREALGPSHELPER() {
		return VELOCREALGPSHELPER;
	}

	public void setVELOCREALGPSHELPER(int vELOCREALGPSHELPER) {
		VELOCREALGPSHELPER = vELOCREALGPSHELPER;
	}

	public int getPOSIÇÃOHELPER_GPS() {
		return POSIÇÃOHELPER_GPS;
	}

	public void setPOSIÇÃOHELPER_GPS(int pOSIÇÃOHELPER_GPS) {
		POSIÇÃOHELPER_GPS = pOSIÇÃOHELPER_GPS;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Data =" + time + ", PONTO_DE_ACELERAÇÃO=" + PONTO_DE_ACELERAÇÃO + ", INDICAÇÃO_MAQUINISTA="
				+ INDICAÇÃO_MAQUINISTA + ", POSIÇÃOHELPER_GPS=" + POSIÇÃOHELPER_GPS + ", VELOCREALGPSHELPER="
				+ VELOCREALGPSHELPER + ", DIST_RELAT_LE=" + DIST_RELAT_LE + ", DIST_RELAT_LD=" + DIST_RELAT_LD
				+ ", VEL_RELAT_LE=" + VEL_RELAT_LE + ", VEL_RELAT_LD=" + VEL_RELAT_LD + ", PRESSAOFREIO=" + PRESSAOFREIO
				+ ", PRESSAO_CILINDRO_PRINCIPAL=" + PRESSAO_CILINDRO_PRINCIPAL + ", BAT_EOT=" + BAT_EOT + ", ID_EOT="
				+ ID_EOT + ", PRESSÃO_EG_EOT=" + PRESSÃO_EG_EOT + ", VELOC_REAL_GPS_EOT=" + VELOC_REAL_GPS_EOT
				+ ", CILINDRO_RETORNO_E=" + CILINDRO_RETORNO_E + ", CILINDRO_AVANCO_E=" + CILINDRO_AVANCO_E
				+ ", CILINDRO_TELEMETRO=" + CILINDRO_TELEMETRO + ", CHAVE_INTERLOCK=" + CHAVE_INTERLOCK
				+ ", TECLA_TELA=" + TECLA_TELA + ", TECLA_BZRESET=" + TECLA_BZRESET + ", TECLA_LIP_PINO_ENGATE="
				+ TECLA_LIP_PINO_ENGATE + ", TECLA_OP_ALINHAR=" + TECLA_OP_ALINHAR + ", E=" + E + ", D=" + D + ", C="
				+ C + ", B=" + B + ", A=" + A + ", CILINDRO_PINO_ENGATE=" + CILINDRO_PINO_ENGATE
				+ ", CILINDRO_RETORNO_D=" + CILINDRO_RETORNO_D + ", CILINDRO_AVANCO_D=" + CILINDRO_AVANCO_D
				+ ", CORTE_TRACAO=" + CORTE_TRACAO + ", EMERGENCIA=" + EMERGENCIA + ", SIRENE=" + SIRENE
				+ ", VALVULA_TELEMETRO=" + VALVULA_TELEMETRO + ", VALVULA_RETORNO_ALINHAMENTO="
				+ VALVULA_RETORNO_ALINHAMENTO + ", VALVULA_AVANÇO_ALINHAMENTO=" + VALVULA_AVANÇO_ALINHAMENTO
				+ ", VALVULA_PINO_ENGATE=" + VALVULA_PINO_ENGATE + ", VELOC_RELATIVA_GPS_EOT_HELPER="
				+ VELOC_RELATIVA_GPS_EOT_HELPER + ", DIST_RELATIVA_GPS_EOT_HELPER=" + DIST_RELATIVA_GPS_EOT_HELPER
				+ ", POSIÇÃO_EOT_GPS=" + POSIÇÃO_EOT_GPS + ", ESTADO_GPS_EOT=" + ESTADO_GPS_EOT + ", CONT_GPS_EOT_VIVO="
				+ CONT_GPS_EOT_VIVO + ", ESTADO_GPS_HELPER=" + ESTADO_GPS_HELPER + ", CONT_GPS_HELPER_VIVO="
				+ CONT_GPS_HELPER_VIVO + ", ESTADO_LASER_END2=" + ESTADO_LASER_END2 + ", CON_LASER_END2="
				+ CON_LASER_END2 + ", ESTADO_LASER_END3=" + ESTADO_LASER_END3 + ", CONT_LASER_END3=" + CONT_LASER_END3
				+ ", TEMP_LASER_END2=" + TEMP_LASER_END2 + ", TEMP_LASER_END3=" + TEMP_LASER_END3 + ", ALARME1="
				+ ALARME1 + ", ALARME2=" + ALARME2 + ", ALARME3=" + ALARME3 + ", LOCALIZACAO_OK_HELPER="
				+ LOCALIZACAO_OK_HELPER + "]";
	}




}
