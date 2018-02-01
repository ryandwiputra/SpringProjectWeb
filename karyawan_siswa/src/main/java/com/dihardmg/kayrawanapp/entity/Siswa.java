package com.dihardmg.kayrawanapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Siswa {
/*	@ManyToOne
    @NotNull
    @JoinColumn(name = "id_karyawan")
	*/
	@Id 
	@Column(name = "NIS")
	private String nis;
	 
	@Column(name = "nama")
	private String nama;
	
	@Column(name = "Tempat_Lahir")
	private String Tempat_Lahir;
	
	@Column(name = "Tanggal_Lahir")
	private String Tanggal_Lahir;
	
	@Column(name = "Jenis_Kelamin")
	private String Jenis_Kelamin;
	
	@Column(name = "Agama")
	private String Agama;
	
	@Column(name = "Anak_Ke")
	private String Anak_Ke;
	
	@Column(name = "Saudara")
	private String Saudara;
	
	@Column(name = "Asal_Sekolah")
	private String Asal_Sekolah;

	@Column(name = "Alamat_Siswa")
	private String Alamat_Siswa;
	/*
	Nama_Ayah,
    Tempat_lahir_Ayah, Tanggal_Lahir_Ayah,
    Pendidikan_Ayah, Pekerjaan_Ayah,
    Telephone_Ayah, Alamat_Ayah,
    
    Nama_Ibu, Tempat_Lahir_Ibu,
    Tanggal_Lahir_Ibu, Pendidikan_Ibu,
    Pekerjaan_Ibu, Telephone_Ibu,
    Alamat_Ibu,
    
    Nama_Wali,
    Tempat_Lahir_Wali, Tanggal_Lahir_Wali,
    Pendidikan_Wali, Pekerjaan_Wali,
    Telephone_Wali, Alamat_Wali; */

	public String getNis() {
		return nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getTempat_Lahir() {
		return Tempat_Lahir;
	}

	public void setTempat_Lahir(String tempat_Lahir) {
		Tempat_Lahir = tempat_Lahir;
	}

	public String getTanggal_Lahir() {
		return Tanggal_Lahir;
	}

	public void setTanggal_Lahir(String tanggal_Lahir) {
		Tanggal_Lahir = tanggal_Lahir;
	}

	public String getJenis_Kelamin() {
		return Jenis_Kelamin;
	}

	public void setJenis_Kelamin(String jenis_Kelamin) {
		Jenis_Kelamin = jenis_Kelamin;
	}

	public String getAgama() {
		return Agama;
	}

	public void setAgama(String agama) {
		Agama = agama;
	}

	public String getAnak_Ke() {
		return Anak_Ke;
	}

	public void setAnak_Ke(String anak_Ke) {
		Anak_Ke = anak_Ke;
	}

	public String getSaudara() {
		return Saudara;
	}

	public void setSaudara(String saudara) {
		Saudara = saudara;
	}

	public String getAsal_Sekolah() {
		return Asal_Sekolah;
	}

	public void setAsal_Sekolah(String asal_Sekolah) {
		Asal_Sekolah = asal_Sekolah;
	}

	public String getAlamat_Siswa() {
		return Alamat_Siswa;
	}

	public void setAlamat_Siswa(String alamat_Siswa) {
		Alamat_Siswa = alamat_Siswa;
	}
	
	
}
