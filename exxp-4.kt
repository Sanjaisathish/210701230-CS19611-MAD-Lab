StudentBasicDetailsFragment.kt:

package com.example.studentdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.studentdetails.databinding.FragmentStudentBasicDetailsBinding

class StudentBasicDetailsFragment : Fragment() {

    private var _binding: FragmentStudentBasicDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStudentBasicDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
StudentMarkDetailsFragment.kt:

package com.example.studentdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.studentdetails.databinding.FragmentStudentMarkDetailsBinding

class StudentMarkDetailsFragment : Fragment() {

    private var _binding: FragmentStudentMarkDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStudentMarkDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

fragment_student_basic_details.xml:

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/etRegisterNo"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Register No."
        android:inputType="text" />

    <EditText
        android:id="@+id/etName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Name"
        android:inputType="text"
        android:layout_marginTop="8dp" />

    <EditText
        android:id="@+id/etDepartment"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Department"
        android:inputType="text"
        android:layout_marginTop="8dp" />
</LinearLayout>

  fragment_student_mark_details.xml:

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/etSSLC"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="SSLC"
        android:inputType="numberDecimal" />

    <EditText
        android:id="@+id/etHSC"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="HSC"
        android:inputType="numberDecimal"
        android:layout_marginTop="8dp" />

    <EditText
        android:id="@+id/etUG"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="UG"
        android:inputType="numberDecimal"
        android:layout_marginTop="8dp" />
</LinearLayout>

  activity_main.xml:

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <fragment
        android:id="@+id/fragmentContainerViewBasic"
        android:name="com.example.studentdetails.StudentBasicDetailsFragment"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1" />

    <fragment
        android:id="@+id/fragmentContainerViewMarks"
        android:name="com.example.studentdetails.StudentMarkDetailsFragment"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1" />
</LinearLayout>

  MainActivity.kt:

package com.example.studentdetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

Add Dependencies:

android {
    ...
    viewBinding {
        enabled = true
    }
}

