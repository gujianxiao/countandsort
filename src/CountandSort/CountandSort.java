package CountandSort;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
public class  CountandSort{


	public static void main(String[] args) throws IOException{
		String path = "E:\\环境测量数据\\divided-zz\\mi";
		int fileCount = 0;
		int folderCount = 0;
		File d = new File(path);
		File list[] = d.listFiles();
		File foldAll[]=new File[6];

		for(int i = 0; i < list.length; i++){
			if(list[i].isDirectory()){
				foldAll[folderCount]=list[i];
				folderCount++;
			}

			else{
				fileCount++;
			}
		}
		for(int j=0;j<folderCount;j++){//计算文件夹总数 遍历所有文件夹
			if(foldAll[j].listFiles()!=null){
				String name=foldAll[j].getName();//获取文件夹名字
				int number=Integer.parseInt(name);//解析文件夹名为数字
				File[] file=foldAll[j].listFiles();//获取所有文件
				for(int k=0;k<file.length;k++)//遍历处理每一个文件
				{
					String fileName=file[k].getName();//获取文件名
					String filerealName=fileName.substring(0, 4);
					int fileNum=Integer.parseInt(filerealName);//解析文件名为数字
					File f = new File("E:\\123.txt");
					if(f.exists()){
						System.out.print("文件存在");
					}else{
						System.out.print("文件不存在");
						f.createNewFile();//不存在则创建
					}
					BufferedReader input = new BufferedReader(new FileReader(f));

					String s;
					String s1 = null;
					while((s = input.readLine())!=null){
						s1 += s;//获取原字符串
					}
					System.out.println(s1);
					input.close();
					s1 += fileNum;
					if(number==50)
						s1+=":1;";
					if(number==100)
						s1+=":2;";
					if(number==150)
						s1+=":3;";
					if(number==200)
						s1+=":4;";
					if(number==300)
						s1+=":5;";
					if(number==500)
						s1+=":6;";					   
					BufferedWriter output = new BufferedWriter(new FileWriter(f));
					output.write(s1);
					output.close();
				}

			}
		}
	}

}

