package com.example.ngoduchiep_qlsp;

public class SanPham {
    private String masp,tensp,loaisp;
    private int soluong;
    private float dongia;
    public SanPham() {
    }

    public SanPham(String masp, String tensp, String loaisp, int soluong, float dongia) {
        this.masp = masp;
        this.tensp = tensp;
        this.loaisp = loaisp;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public SanPham(String masp) {
        this.masp = masp;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "masp='" + masp + '\'' +
                ", tensp='" + tensp + '\'' +
                ", loaisp='" + loaisp + '\'' +
                ", soluong=" + soluong +
                ", dongia=" + dongia +
                '}';
    }
}
