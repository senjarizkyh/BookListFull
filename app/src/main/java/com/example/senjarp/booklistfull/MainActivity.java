package com.example.senjarp.booklistfull;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    Button btnSimpan;
    ListView listViewBook;
    EditText editTextJudul, editTextAuthor, editTextPage;

    ArrayList<String> listOfBook=new ArrayList<>();


    
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listViewBook= (ListView) findViewById(R.id.listViewBook);
        editTextJudul= (EditText) findViewById(R.id.editTextJudul);
        editTextAuthor= (EditText) findViewById(R.id.editText2Author);
        editTextPage= (EditText) findViewById(R.id.editText3Page);
        btnSimpan= (Button) findViewById(R.id.btn_simpan);

        listOfBook.add("Laskar Pelangi"+ "Andrea Hirata" + "356");
        listOfBook.add("5 cm");
        listOfBook.add("Ayat ayat cinta,");
        listOfBook.add("Lima Menara");
        listOfBook.add("Tutorial Pemrograman Android");

        //meng-inisiasi arrayadapter
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listOfBook);
        listViewBook.setAdapter(adapter);


        //mengaktifkan fungsi onItemClickListener dan onItemLongClickListener
        listViewBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //something happen
                String clickedItem = (String) parent.getAdapter().getItem(position);
                Log.d("booklistfull", clickedItem);
            }
        });

        listViewBook.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //something happen
                String longClickedItem= (String) parent.getAdapter().getItem(position);
                Log.d("booklistfull",longClickedItem);
                showDeleteDialog(longClickedItem);
                return false;
            }
        });

        // mengaktifkan fungsi button simpan
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //something happen if user click this button
                String title=editTextJudul.getText().toString();
                // dilakukan check untuk memastikan bahwa user telah menulis judul buku
                if(!title.isEmpty()){
                    // menambahkan judul buku kedalam listOfBook
                    listOfBook.add(title);
                    // meng-update listview
                    adapter.notifyDataSetChanged();
                    // clear edittext
                    editTextJudul.setText("");
                }else{
                    Toast.makeText(getApplicationContext(), "judul buku wajib diisi", Toast.LENGTH_SHORT).show();
                }

                String pengarang=editTextAuthor.getText().toString();
                // dilakukan check untuk memastikan bahwa user telah menulis judul buku
                if(!title.isEmpty()){
                    // menambahkan judul buku kedalam listOfBook
                    listOfBook.add(pengarang);
                    // meng-update listview
                    adapter.notifyDataSetChanged();
                    // clear edittext
                    editTextAuthor.setText("");
                }else{
                    Toast.makeText(getApplicationContext(), "pengarang buku wajib diisi", Toast.LENGTH_SHORT).show();
                }

                String halaman=editTextPage.getText().toString();
                // dilakukan check untuk memastikan bahwa user telah menulis judul buku
                if(!title.isEmpty()){
                    // menambahkan judul buku kedalam listOfBook
                    listOfBook.add(halaman);
                    // meng-update listview
                    adapter.notifyDataSetChanged();
                    // clear edittext
                    editTextPage.setText("");
                }else{
                    Toast.makeText(getApplicationContext(), "jumlah halaman buku wajib diisi", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showDeleteDialog(final String bookTitle){
        AlertDialog.Builder deleteDialog=new AlertDialog.Builder(this);
        deleteDialog.setMessage("Anda yakin untuk menghapus \n"+bookTitle+"?");
        deleteDialog.setPositiveButton("Ya",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                listOfBook.remove(bookTitle);
                // setelah menghapus, kita perlu meng-update listview
                adapter.notifyDataSetChanged();
            }
        });
        deleteDialog.setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        deleteDialog.show();
    }
}

