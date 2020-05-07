import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
public class Test
{
    public static void main(String args[])
    {
        FastScanner input = new FastScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);
    }
    static class FastScanner
    {
        private InputStream stream;
        private byte[] buffer = new byte[1 << 22];
        private int curChar;
        private int numChars;
        
        public FastScanner(InputStream stream)
        {
            this.stream = stream;
        }
        
        public FastScanner(File f) throws FileNotFoundException
        {
            this(new FileInputStream(f));
        }
        
        public FastScanner(String s)
        {
            this.stream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
        }
        int read()
        {
            if(numChars == -1)
                throw new InputMismatchException();
            if(curChar >= numChars)
            {
                curChar = 0;
                try 
                {
                    numChars = stream.read(buffer);
                } catch(IOException e) 
                {
                    throw new InputMismatchException();
                }
                if(numChars <= 0)
                    return -1;
            }
            return buffer[curChar++];
        }
        boolean isSpaceChar(int c)
        {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1; 
        }
        boolean isEndLine(int c)
        {
            return c == '\n' || c == '\r' || c == -1;
        }
        public String next()
        {
            int c = read();
            while(isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do
            {
                res.appendCodePoint(c);
                c = read();
            }while(!isSpaceChar(c));
            return res.toString();
        }
        public String nextLine()
        {
            int c = read();
            while(isEndLine(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do
            {
                res.appendCodePoint(c);
                c = read();
            }while(!isEndLine(c));
            return res.toString();
        }
        public int nextInt()
        {
            return Integer.parseInt(next());
        }
        public long nextLong()
        {
            return Long.parseLong(next());
        }
        public double nextDouble()
        {
            return Double.parseDouble(next());
        }
        public int[] nextIntArray(int n)
        {
            int ret[] = new int[n];
            for(int i = 0;i < n; i++)
            {
                ret[i] = this.nextInt();
            }
            return ret;
        }
        public int[][] next2DIntArray(int n, int m)
        {
            int ret[][] = new int[n][];
            for(int i = 0;i < n; i++)
            {
                ret[i] = this.nextIntArray(m);
            }
            return ret;
        }
        public long[] nextLongArray(int n)
        {
            long ret[] = new long[n];
            for(int i = 0;i < n; i++)
            {
                ret[i] = this.nextLong();
            }
            return ret;
        }
        public long[][] next2DLongArray(int n, int m)
        {
            long ret[][] = new long[n][];
            for(int i = 0;i < n; i++)
            {
                ret[i] = this.nextLongArray(m);
            }
            return ret;
        }
        public double[] nextDoubleArray(int n)
        {
            double ret[] = new double[n];
            for(int i = 0;i < n; i++)
            {
                ret[i] = this.nextDouble();
            }
            return ret;
        }
        public double[][] next2DDoubleArray(int n, int m)
        {
            double ret[][] = new double[n][];
            for(int i = 0;i < n; i++)
            {
                ret[i] = this.nextDoubleArray(m);
            }
            return ret;
        }
        void close()
        {
            try
            {
                stream.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}