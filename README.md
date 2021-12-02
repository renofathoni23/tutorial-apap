# Tutorial APAP

##Authors

* **Reno Fathoni** - *1906399461* - *A*
## Tutorial 8
### ReactJS 2

#### Pertanyaan 1: Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian melakukan langkah - langkah tersebut?
Jawab: Setelah this.loadData(), saya mengeset value form kembali menjadi kosong dengan menggunakan `this.setState({title:" ", price:0, description:" ", category:" ", quantity:0})`
sehingga ketika membuka modalnya kembali, maka fieldnya akan menjadi kosong lagi.
#### Pertanyaan 2: Jelaskan fungsi dari async dan await!
Jawab: Fungsi async memungkinkan kode untuk terus berjalan saat satu fungsi masih menunggu nilai returnnya, atau saat menggunakan asinkron JavaScript dan await untuk memastikan baris tertentu tidak berjalan hingga fungsi mengembalikan nilai.
#### Pertanyaan 3: Masukkan jawaban dari Screenshot yang diperintahkan di halaman 9 pada Component Lifecycle pada pertanyaan ini
Jawab: Screenshot dapat dilihat pada link berikut https://drive.google.com/drive/folders/1oFONxQXg_OsEIP0V6ATMpDNfZvjZ3j7E?usp=sharing
#### Pertanyaan 4: Jelaskan fungsi dari componentDidMount, shouldComponentUpdate,componentDidUpdate, componentWillReceiveProps, componentWillUnmount.Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja yang biasanya menggunakan lifecycle method tersebut”.
Jawab: componentDidMount berfungsi ketika komponen selesai dibuat, usecase yang biasanya menggunakannya adalah ketika ingin mengetauhi suatu komponen selesai dibuat.
shouldComponentUpdate berfungsi ketika property atau state sudah berubah, usecase yang biasa menggunakannya adalah ketika ingin mengetauhi perubahan dari props atau state dari komponen.
componentDidUpdate berfungsi ketika sebelum ataupun sesudah komponen dirender kembali, usecase yang biasa menggunakannya adalah ketika ada pekerjaan manual dari luar react yang update si component.
componentWillReceiveProps berfungsi ketika dipanggil sebelum komponen menerima props yang nilainya berubah, usecase yang biasa menggunakananya adalah ketika mengubah component.
componentWillUnmount berfungsi ketika ingin menghapus komponen, usecase yang biasa menggunakannya adalah ketika ingin unsubscribe
## Tutorial 7
### ReactJS 1

#### Pertanyaan 1: Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.
soal 1

Saya mengaktifkan tombol delete button yang sudah disediakan sebelumnya sehingga barang yang didelete pada cart akan hilang dan tombol cart pada shop list akan
aktif kembali. Pada nomor ini saya membuat function untuk menghandle delete yang saya namanakan 'handleDeleteItemfromCart'. Lalu dalam function tersebut terdapat 
for loop yang jika cartItems[i].id sama dengan item.id, maka akan cartItems[i].id akan di set inCart nya menjadi False dan akan menggunakan function 
updateShopItem(this.state.cartItems[i], false), lalu mengeluarkan item tersebut dari cartItems dengan method splice(i,1)

Link code: https://ibb.co/85gYG03

soal 2
Pada soal ini, saya mengimplementasi agar ketika user klik suatu barang untuk dimasukan ke cart, balance akan berkurang sesuai dengan harga barangnya. Begitupun
pada Cart,ketika user mendelete suatu barang, maka balancenya akan bertambah. disini saya menambahkan kode pada function handleDeleteItemfromCart dan
handleAddItemtoCart. Saya menambahkan kode `this.state.balance += this.state. cartItems[i].price` didalam forloop pada handleDeleteItemfromCart dimana kode
tersebut akan menambah balance sesuai dengan harga item yang didelete. Lalu didalam `if(targetInd<0)` saya menambahkan kode `this.state.balance -= newItem.price`
sehingga balance akan berkurang ketika user menambahkan item kedalam cart.

Link code: https://ibb.co/3BnT1DH

soal3
Pada soal ini, saya menambahkan alert jika user mencoba membeli barang yang harganya lebih tinggi dari pada balance yang dimiliki. Pada kasus ini, saya menambahkan
hanya menambkan conditional if else, dimana if adalah ketika balance - harga item lebih besar atau sama dengan 0, maka item tersebut akan berhasil dimasukan ke cart.
Lalu elsenya berarti balance < harga item sehingga saya menambahkan kode  `alert("Balance not sufficient")`. 

Link Code: https://ibb.co/Ht6MVqr

#### Pertanyaan 2: Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?

Jawab: state adalah variabel yang didefinisikan didalam sebuah class, sedangkan props adalah variabel yang berasal dari luar class.

#### Pertanyaan 3: Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam React? sebutkan alasannya.

Jawab: Menurut saya dengan menggunakan component, kita dapat membuat aplikasi atau web dengan membaginya kedalam komponen-komponen kecil sehingga
ini akan mempermudah dalam mengembangkan kode karena akan lebih mudah untuk dibaca, jika ada perubahan pun maka kita cukup merubah pada komponen yang 
ingin dirubah sehingga tidak perlu merubah pada semua kode yang ada. Mudah untuk dipahami karena dibentuk ke dalam komponen-komponen. 

#### Pertanyaan 4: Apa perbedaan class component dan functional component?

Jawab: Functional component sebenarnya adalah function Javascript dengam satu parameter atau objek props yang akan mengembalikan komponen React. Sedangkan Class
component sebenarnya function yang mengimplementasikan OOP. Functional component digunakan untuk meminimalisir this.state yang berlebih sehingga kodenya akan
lebih simple.

#### Pertanyaan 5: Dalam react, apakah perbedaan component dan element?

Jawab: Elemen adalah objek biasa yang ingin ditampilkan pada layar dalam bentuk DOM atau komponen lain. Lalu Component adalah suatu class atau fungsi Javascript
yang menerima input berupa props atau properties dan akan mengembalikan React Element yang akan ditampilkan pada layar, biasanya adalah HTML.

referensi:
https://blog.logrocket.com/react-functional-components-3-advantages-and-why-you-should-use-them-a570c83adb5e/, https://ozmoroz.com/2018/08/react-functional-vs-class-components/, https://medium.com/the-andela-way/understanding-react-components-37f841c1f3bb#:~:text=Components%20are%20the%20building%20blocks,(User%20Interface)%20should%20appear.

## Tutorial 6
### Web Security
####Pertanyaan 1: Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?

Jawab: Otentikasi adalah proses memverifikasi siapa yang akan login. Saat seseorang
sedang login dengan username dan kata sandi, disitulah proses otentikasi

Contoh code:

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

Otorisasi adalah proses memverifikasi bahwa seseorang memiliki akses tertentu. Biasanya
terdapat role-role tentu pada user. proses otoriasasi ini akan mengecek apakah user tersebut
memiliki akses ke resource-resource tertentu atau tidak.

Contoh code:

   `.antMatchers("/user/viewall").hasAuthority("Admin")`

   `<div sec:authorize="hasAuthority('Admin')`

####Pertanyaan 2: Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya

Jawab: BCryptPasswordEncoder adalah encoder kata sandi satu arah. Algoritma penyandian satu arah digunakan untuk mengenkripsi kata sandi.
Cara kerjanya akan secara otomatis men-generate dan lalu menggunakan random salt untuk menentukan hashingnya, sehingga nanti akan menghasilkan hasing yang berbeda-beda.
Sehingga nantinya password yang dimasukan user akan tergenerate menjadi kode hash yang dapat dilihat pada database.

####Pertanyaan 3: Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa demikian?

Jawab: Hashing berguna untuk memvalidasi integritas konten dengan mendeteksi semua perubahan dan kemudian mengubah nilai hash sebagai output. Dan, Enkripsi berguna untuk penyandian data dengan tujuan menjaga kerahasiaan dan keamanan data. Ini membutuhkan kunci pribadi untuk mendekripsi data terenkripsi.
Dengan alasan diatas seharunya lebih baik menggunakan enkripsi karena sangat berguna dalam penyandian data dan tujuannya pun agar menjaga kerahasiaan.

####Pertanyaan 4: Jelaskan secara singkat apa itu UUID beserta penggunaannya!

Jawab: UUID adalah Universally Unique Identifier, yaitu kumpulan dari 32 karakter/string acak. Karena memiliki pola acak, UUID sangat berguna bagi developer dari serangan Hacker.
UUID biasanya digunakan untuk keamanan data. 

####Pertanyaan 5: Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut

Jawab: Class UserDetailsServiceImpl.java adalah class yang mengimplementasi interface UserDetailService. interface tersebut berguna untuk user DAO saat mengambil informasi mengenai
otentikasi serta otorisasi kepada user.

Sumber: https://www.priawadi.com/2019/09/generate-uuid-secara-otomatis-untuk.html, https://aboutssl.org/hashing-vs-encryption/, https://it-qa.com/how-do-i-decode-bcryptpasswordencoder/,
https://qastack.id/server/57077/what-is-the-difference-between-authentication-and-authorization

## Tutorial 5
### Web Service
Pertanyaan 1: Apa itu Postman ? Apa kegunaannya ?

Jawab: Postman adalah aplikasi yang berfungsi sebagai REST CLIENT untuk menguji coba 
REST API. Kegunaan dari Postman adalah sebagai tools oleh developer untuk menguji API
yang telah mereka buat. Postman juga menyediakan fitur lain yaitu Sharing Collection
API for Documentation, Testing API, Realtime Collaboration Team, Monitoring API, Integration.

Pertanyaan 2: Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.

Jawab: @JsonIgnoreProperties digunakan untuk mengabaikan properti logis yang ditentukan dalam
serialisasi dan deserialisasi JSON. Dijelaskan di tingkat kelas. Hal ini dapat memudahkan
dalam pemanggilan REST dan menghasilkan objek domain. @JsonProperty adalah anotasi penanda
untuk mendefinisikan properti logis. @JsonProperty dapat dijelaskan di setter non-statis
atau metode pengambil atau bidang objek non-statis. Properti logis digunakan dalam serialisasi
dan deserialisasi JSON

Pertanyaan 3: Apa kegunaan atribut WebClient?

Jawab: Webclient digunakan untuk restserviceimpl yang digunakan untuk mengirim dan menerima
data dari sumber uri.

Pertanyaan 4: Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?

Jawab: ResponseEntity mewakili response HTTP, termasuk header, isi, dan juga status.
ResponseEntity memungkinkan kita untuk menambahkan header dan kode status. Lalu BindingResult
menyimpan hasil validasi, pengikatan, dan berisi kesalahan yang mungki terjadi. BindingResult
harus ada tepat setelah objek model divalidasi atau Spring gagal memvalidasi objek dan melempar
pengecualian.

## Tutorial 4
### Presentation Layer using Thymeleaf
Pertanyaan 1: Jelaskan perbedaan th:include dan th:replace!

Jawab:th:replace digunakan untuk memasukan code yang ada difragment ke dalam tag div sehingga nantinya konten yang ada difragment juga akan ditampilkan.
th:replace digunakan untuk mengganti host tag dengan code atau konten yang ada difragment.


Pertanyaan 2: Jelaskan apa fungsi dari th:object!

Jawab: berfungsi untuk menspesifikasikan suatu object yang akan disubmit pada suatu form. Wajib digunakan jika suata data atau objek ingin tersimpan ketika sudah mengisi form.

Pertanyaan 3: Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?

Jawab:*{} atau asterisk digunakan untuk mengevaluasi suatu objek yang sudah dideklarasi pada controller, ${} digunakan untuk mengevaluasi secara utuh suatu objek atau atribut.

Referensi: https://stackoverflow.com/questions/37103958/difference-between-thymeleaf-include-and-replace, https://o7planning.org/12385/thymeleaf-th-object-and-asterisk-syntax,https://o7planning.org/12385/thymeleaf-th-object-and-asterisk-syntax
## Tutorial 3
### Database & Relasi DataBase dalam Project Spring Boot

Pertanyaan 1: Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model
(@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)

Jawab: @AllArgsConstructor berfungsi untuk menghasilkan konstruktor yang membutuhkan argumen pada class. @NoArgsConstructor berfungsi untuk generate empty constructor. @Setter dan @Getter berfungsi untuk mengenerate fungsi setter dan getter pada suatu class secara otomatis. 
@Entity mendifiniskan bahwa kelas berkoleasi dengan tabel yang ada pada database.@Table berfungsi untuk menentukan nama tabel database yang akan digunakan untuk pemetaan.

Pertanyaan 2: Pada class CabangDB, terdapat method findByNoCabang, apakah kegunaan dari method
tersebut?

Jawab: Kegunaan dari Method tersebut adalah mencari Objek Cabang sesuai dengan nomor Cabangnya (noCabang)

Pertanyaan 3: Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn

Jawab: @JoinColumn berfungsi untuk membuat kolom pada database dan kolom itu akan selalu merefer pada kolom lain (menggunakan foreign key).
@JoinTable digunakan untuk memetekan beberapa asosiasi seperti  bidirectional many-to-one/one-to-many, unidirectional many-to-one, dan one-to-one ke tabel database.

Pertanyaan 4: Pada class PegawaiModel, digunakan anotasi @JoinColumn pada atribut cabang, apa
kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa
perbedaan nullable dan penggunaan anotasi @NotNull

Jawab: referencedColumnName adalah kolom yang dirujuk dari kolom lain (foreign key), sedangkan
name adalah nama kolom pada suatu entity. Lalu nullable digunakan untuk mencegah adanya nilai null dalam database. Perbedaan antara
nullable dan anotasi @NotNull adalah nullable menunjukan status null dari atribut sedangkan @NotNull digunakan agar tidak ada data null yang masuk kedalam database. 

Pertanyaan 5: Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
FetchType.EAGER berfungsi untuk mengambil 

Jawab:
FetchType.LAZY digunakan untuk mengakses kolom atau atribut yang dibutuhkan saja. Biasanya menggunakan method get untuk mendapatkan datanya.
FetchType.EAGER digunakan untuk mengambil kolom atau atribut yang berelasi ketika parent entity difetch.
CascadeType.ALL digunakan untuk menyebarkan operasi (PERSIST, REMOVE, REFRESH, MERGE, DETACH) ke entitas terkait.

Referensi: http://www.javabyexamples.com/delombok-allargsconstructor-noargsconstructor-and-requiredargsconstructor/ , https://projectlombok.org/features/GetterSetter, https://zetcode.com/springboot/annotations/, https://www.baeldung.com/jpa-join-column, https://www.baeldung.com/hibernate-notnull-vs-nullable, https://stackoverflow.com/questions/2990799/difference-between-fetchtype-lazy-and-eager-in-java-persistence-api, https://thorben-janssen.com/entity-mappings-introduction-jpa-fetchtypes/   

## Tutorial 2
### What I have learned today
### Organizing Domain Logic
Pertanyaan 1: Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut setelah menjalankan program: http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung% 20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi

Jawab: Akan terjadi error saat mengakses link tersebut dikarenakan saya belum membuat
file HTML untuk view yang akan return pada method yang ada dicontroller.

Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat

Jawab: Implementasi dari konsep Dependency Injection dimana fitur ini memungkinkan Spring untuk menyelesaikan dan menyuntikkan beans ke beans lain.
Setelah mengaktifkan injeksi anotasi, kita dapat menggunakan autowiring pada properti, setter, dan konstruktor. Sehingga kita tidak perlu menulis ulang setter method atau menambahkan argumen pada constructor.@Autowired bekerja dengan mencari class yang terdapat @Repository, @Service, @Controller dan kemudian akan dilakukan inisiasi terhadap class-class yang ada.
Referensi: https://www.baeldung.com/spring-autowire@

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
