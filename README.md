# Tutorial APAP

##Authors

* **Reno Fathoni** - *1906399461* - *A*
## Tutorial 2
### What I have learned today
### Organizing Domain Logic
Pertanyaan 1: Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut setelah menjalankan program: http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung% 20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi

Jawab: Akan terjadi error saat mengakses link tersebut dikarenakan saya belum membuat
file HTML untuk view yang akan return pada method yang ada dicontroller.

Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat

Jawab: Implementasi dari konsep Dependency Injection dimana fitur ini memungkinkan Spring untuk menyelesaikan dan menyuntikkan beans ke beans lain.
Setelah mengaktifkan injeksi anotasi, kita dapat menggunakan autowiring pada properti, setter, dan konstruktor.
Referensi: https://www.baeldung.com/spring-autowire

Pertanyaan 3: Cobalah untuk menambahkan sebuah Kebun dengan mengakses link
berikut:
http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung%
20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.

Jawab: Akan menyebabkan error karena tidak terdapat attribut No Telepon yang akan 
ditambahkan. Method addKebunSafari membutuhkan parameter No Telepon jika ingin berhasil
menambahkan kebun safari baru ke dalam list.

Pertanyaan 4: Jika Papa APAP ingin melihat Kebun Safari dengan nama Papa APAP,link apa yang harus diakses?

Jawab: Terdapat 2 link yang dapat dibuka yaitu "/kebun-safari" dengan @RequestParam atau
"/kebun-safari/view/{idKebunSafari}" dengan @PathVariable. link diatas digunakan untuk melihat
detail dari objek kebun safari berdasarkan Id-nya. Sehingga jika Kebun Safari dengan nama Papa APAP
dengan id=1 ingin ditampilkan, maka dapat menggunakan http://localhost:8080/kebun-safari/view/1 atau http://localhost:8080/kebun-safari/?id=1 

Pertanyaan 5: Tambahkan 1 contoh Kebun Safari lainnya sesukamu. Lalu cobalah
untuk mengakses http://localhost:8080/ , apa yang akan ditampilkan? Sertakan juga
bukti screenshotmu.

Jawab: Akan menampilkan Kebun Safari yang berada pada list beserta data-datanya. Karena
saya menambahkan Kebun Safari dengan ID kebun Safari = 2 nama = Papa Boom, Alamat = Quanta Fasilkom, 
dan Nomor Telepon = 08123xx sehingga terdapat objek tersebut pada list.
gambar:https://drive.google.com/file/d/1gf78ahsrVsOia8EmnV5qSMdwUF8A6WEQ/view?usp=sharing
## Tutorial 1
### What I have learned today
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
   Issue Tracker adalah fitur padad Github yang berguna untuk melacak ide, masukan, tugas, atau bug yang sedang dikerjakan pada Github. Dengan adanya Issue Tracker, kita akan dengan mudah untuk tetap on track pada projek yang sedang dikerjakan dan juga dapat tahu jika ada perubahan perubahan terhadap projek seperti penamabahan atau pengurangan fitur. Issue Tracker ini juga membantu dalam tracking bug-bug yang ada.
   Masalah yang dapat diselesaikan adalah: Bugs, Documentation, Duplicate, Enhancment, Good First Issue, Help Wanted, Invalid, Question, Wontfix.
   Refrensi: https://docs.github.com/en/issues/tracking-your-work-with-issues/about-issues

2. Apa perbedaan dari git merge dan git merge --squash?
   Perbedaannya adalah git merge –squash akan mengambil semua commit pada branch menjadi satu commit sehingga saat dimerge ke main branch hanya terdapat 1 commit itu. Jika merge, akan melakukan semua commit pada branch ke main branchnya.
   Refrensi: https://monsterlessons-academy.com/p/git-squash-how-to-combine-git-commits-with-merge-and-rebase

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
   suatu aplikasi?
   Keunggulannya dari Version Control System adalah dapat mengurangi resiko gagal pada kode atau data yang sudah diubah. Version Control System ini akan mengelola perubahan pada source code. Jika terdapat kesalahan pada source code, pengembang dapat membandingkan kode versi sebelumnya dengan sesudahnya. Sehingga Version Control System ini sangat membantu tim pengembang terutama pada kesalahan/error yang ada pada source code.
   Refrensi: https://glints.com/id/lowongan/version-control-system/#.YTjZGp0zaUk

### Spring
4. Apa itu library & dependency?
   Library pada pemogramman adalah kumpulan source code yang terkumpul pada sebuah modul yang dapat dipakai oleh kita untuk memudahkan pengembangan projek. Lalu dependency adalah istilah yang digunakan untuk merujuk suatu software yang berkaitan dengan software lainnya.
   Refrensi: https://id.quora.com/Apa-yang-dimaksud-dengan-library-pada-pemrograman, https://coderslegacy.com/what-are-dependencies-in-programming/

5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
   Maven adalah suatu tool yang sering digunakan dalam pengembangan aplikasi java yang berbasis pada konsep Project Object Model (POM). Dengan Maven kita dapat mengcomplie source code dengan mudah, melakukan testing, menginstall library yang dibutuhkan.  Beberapa Alternatif dari Maven adalah Azure DevOps, Gradle, CMake
   Referensi: https://www.petanikode.com/java-maven/ , https://maven.apache.org

6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
   framework?
   Spring Framework dapat digunakan untuk Reactive, Event Driven, Cloud, Serverless, dan juga Batch
   Refrensi: https://spring.io/projects/spring-framework (why spring)

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
   menggunakan @RequestParam atau @PathVariable?
   Keduanya sama sama digunakan untuk mengambil value dari request parameters. Hanya saja @RequestParam digunakan untuk mengakses nilai dari query parameter sedangkan @PathVariable digunakan untuk mengakses nilai dari templete URI.
   Referensi: https://javabeat.net/spring-mvc-requestparam-pathvariable/

### What I did not understand
Sebenarnya saya masih kurang paham menggunakan Github karena belum terbiasa dan juga ini kali pertama saya menggunakan merge pada suatu projek karena biasanya saya langsung push ke main branch.
- [ ] Saya masih kurang paham mengenai Dependency dan juga penggunaan Maven dalam Projek Java
